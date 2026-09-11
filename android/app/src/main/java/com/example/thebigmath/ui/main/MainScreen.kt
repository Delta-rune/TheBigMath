package com.example.thebigmath.ui.main

import com.example.thebigmath.data.CalculationManager
import com.example.thebigmath.MainActivity
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation3.runtime.NavKey
import kotlinx.coroutines.delay
import kotlin.random.Random
import android.widget.Toast

// Authentic Mobile Calculator Palette (Pure Black & Stark High-Contrast)
val BgBlack = Color(0xFF000000)
val CalcSurface = Color(0xFF000000)
val BorderSubtle = Color(0x33FFFFFF)
val BorderWhite = Color(0xFFFFFFFF)
val InkBlack = Color(0xFF000000)
val InkWhite = Color(0xFFFFFFFF)
val TextMuted = Color(0xFF8E8E93)
val BtnNumBg = Color(0xFF1C1C1E)
val BtnFnBg = Color(0xFF2C2C2E)
val BtnOpBg = Color(0xFFFFFFFF)
val CardDark = Color(0xFF09090B)
val GrayDark = Color(0xFF18181B)

data class CaptchaTile(val label: String, val icon: String)

data class QuizQuestion(
    val title: String,
    val text: String,
    val isEvasive: Boolean = false,
    val isCaptcha: Boolean = false,
    val captchaTiles: List<CaptchaTile> = emptyList(),
    val options: List<QuizOption> = emptyList()
)

data class QuizOption(
    val text: String,
    val response: String,
    val penaltySeconds: Int = 15
)

@Composable
fun MainScreen(
    onItemClick: (NavKey) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val haptic = LocalHapticFeedback.current
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    var input by CalculationManager::input
    var historyText by CalculationManager::historyText
    var isComputing by CalculationManager::isComputing
    var isTurbo by CalculationManager::isTurbo
    var justFinished by CalculationManager::justFinished
    var showMagnificentModal by CalculationManager::showMagnificentModal

    // Computation State
    var progress by CalculationManager::progress
    var statusText by CalculationManager::statusText
    var bogusResult by CalculationManager::bogusResult
    var bogusProof by CalculationManager::bogusProof

    // Quiz State with Lock-In & Captcha Support
    var showQuiz by CalculationManager::showQuiz
    var isBribeQuiz by CalculationManager::isBribeQuiz
    var quizStep by CalculationManager::quizStep
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isLockedIn by remember { mutableStateOf(false) }
    val selectedCaptchaTiles = remember { mutableStateListOf<Int>() }
    var quizFeedback by remember { mutableStateOf<String?>(null) }
    var evasiveOffsetX by remember { mutableStateOf(0) }
    var evasiveOffsetY by remember { mutableStateOf(0) }

    // Inescapable Lockdown System: Prevent leaving until result is delivered!
    var showLockdownDialog by CalculationManager::showLockdownDialog
    var escapeAttempts by CalculationManager::escapeAttempts
    var lockdownPenaltyTotal by CalculationManager::lockdownPenaltyTotal
    var evasiveEscapeOffsetX by remember { mutableStateOf(0) }
    var evasiveEscapeOffsetY by remember { mutableStateOf(0) }

    // Safeguard & Lockdown: Prevent accidental exit or closing while computing or admiring output
    BackHandler(enabled = isComputing || showMagnificentModal || justFinished || showLockdownDialog || showQuiz) {
        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
        if (showQuiz) {
            Toast.makeText(context, "🚫 QUIZ LOCKED: Verification must be completed!", Toast.LENGTH_SHORT).show()
        } else if (showLockdownDialog) {
            escapeAttempts++
            lockdownPenaltyTotal += 20
            CalculationManager.saveState(context)
            Toast.makeText(context, "🚨 ESCAPE PROHIBITED! Additional +20s penalty added to queue.", Toast.LENGTH_SHORT).show()
        } else if (isComputing) {
            escapeAttempts++
            lockdownPenaltyTotal += 25
            CalculationManager.lockdownTitle = "🚨 BACK GESTURE BLOCKED"
            CalculationManager.lockdownMessage = "You attempted to navigate back to the home screen! Arithmetic core quarantined. A +25s penalty tariff has been added."
            showLockdownDialog = true
            CalculationManager.saveState(context)
            Toast.makeText(context, "🚨 ARITHMETIC LOCKDOWN ACTIVATED! Exit is blocked!", Toast.LENGTH_SHORT).show()
        } else if (showMagnificentModal) {
            Toast.makeText(context, "Admire this mathematical masterpiece! Use dialog actions to dismiss.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Your magnificent result is on screen. Tap AC to start over.", Toast.LENGTH_SHORT).show()
        }
    }

    val telemetryLogs = remember {
        listOf(
            "Translating input arithmetic into Sumerian Cuneiform...",
            "Consulting Pythagoras via cryptographic Ouija daemon...",
            "ALU reports floating point emotional instability...",
            "Deploying 700B neural net to add two single digits...",
            "Pouring virtual liquid nitrogen on ALU...",
            "Applying Heisenberg Uncertainty: Value is unknown...",
            "Consulting tax accountant for mathematical deductions...",
            "Validating Riemann Hypothesis for digit registers...",
            "Running 10,000 Monte Carlo simulations of the plus sign...",
            "Checking if 1 + 2 has changed since yesterday..."
        )
    }

    // Dynamic selection of 10 to 14 questions from the 106-question pool (strictly >= 10)
    var activeQuizQuestions by remember { mutableStateOf(QuestionBank.getRandomQuestions(10, 14)) }


    // Computation Coroutine: Agonizingly Slow (90s normal, 25s turbo, strictly capped at 3 minutes maximum!)
    LaunchedEffect(isComputing) {
        if (isComputing) {
            val baseTime = if (isTurbo) CalculationManager.TURBO_BASE_DURATION_MS else CalculationManager.NORMAL_BASE_DURATION_MS
            val maxCap = CalculationManager.MAX_CALCULATION_DURATION_MS // Strictly 180s (3 minutes)
            var elapsed = CalculationManager.elapsedMs
            var lastSaveTime = System.currentTimeMillis()

            var regressed1 = elapsed > (baseTime * 0.32f)
            var regressed2 = elapsed > (baseTime * 0.56f)
            var regressed3 = elapsed > (baseTime * 0.80f)
            var regressed4 = elapsed > (baseTime * 0.95f)

            while (isComputing) {
                // Total duration strictly capped at 3 minutes (180 seconds)!
                val total = (baseTime + (lockdownPenaltyTotal * 1000)).coerceAtMost(maxCap)

                delay(100)
                elapsed += 100
                CalculationManager.elapsedMs = elapsed
                var currentProg = (elapsed.toFloat() / total.toFloat()) * 100f

                // 4 Cruel Regressions (visual delays without making the timer infinite!)
                if (currentProg in 28f..32f && !regressed1) {
                    currentProg = 16f
                    regressed1 = true
                    statusText = "⚠️ REGRESSION: Forgot to carry the 0. Re-evaluating..."
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    CalculationManager.saveState(context)
                }
                if (currentProg in 52f..56f && !regressed2) {
                    currentProg = 32f
                    regressed2 = true
                    statusText = "⚠️ REGRESSION: Riemann hypothesis unverified. Cache flushed!"
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    CalculationManager.saveState(context)
                }
                if (currentProg in 76f..80f && !regressed3) {
                    currentProg = 54f
                    regressed3 = true
                    statusText = "⚠️ REGRESSION: Thermal throttling. Virtual liquid nitrogen reboot!"
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    CalculationManager.saveState(context)
                }
                if (currentProg in 92f..95f && !regressed4) {
                    currentProg = 75f
                    regressed4 = true
                    statusText = "⚠️ REGRESSION: Checking negative zero parity..."
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                    CalculationManager.saveState(context)
                }

                progress = currentProg.coerceIn(0f, 99f)

                if (Random.nextInt(100) < 12) {
                    statusText = telemetryLogs.random()
                }

                val now = System.currentTimeMillis()
                if (now - lastSaveTime > 3000) {
                    lastSaveTime = now
                    CalculationManager.saveState(context)
                }

                // Trigger mandatory audit quiz during computation at ~35% if not turbo
                if (progress in 35f..40f && !isTurbo && quizStep == 0 && !showQuiz) {
                    isBribeQuiz = false
                    activeQuizQuestions = QuestionBank.getRandomQuestions(10, 14)
                    showQuiz = true
                    CalculationManager.saveState(context)
                }

                if (elapsed >= total) {
                    break
                }
            }


            // Finish Computation: Deliver the certified result!
            if (isComputing) {
                isComputing = false
                justFinished = true
                input = bogusResult
                historyText = "$historyText ="
                showMagnificentModal = true
                showLockdownDialog = false
                CalculationManager.saveState(context)
                (context as? MainActivity)?.unpinScreen()
                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            }
        }
    }


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BgBlack)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // 1. Discreet Top Function Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Image(
                        painter = painterResource(id = com.example.thebigmath.R.drawable.app_logo),
                        contentDescription = "The Big Math! Logo",
                        modifier = Modifier.size(24.dp).clip(RoundedCornerShape(6.dp))
                    )
                    Text("The Big Math!", fontWeight = FontWeight.Bold, color = TextMuted, fontSize = 13.sp)
                }

                // Turbo Bribe Button
                Surface(
                    shape = RoundedCornerShape(100.dp),
                    color = if (isTurbo) InkWhite else BtnNumBg,
                    border = androidx.compose.foundation.BorderStroke(1.dp, if (isTurbo) BorderWhite else BorderSubtle),
                    modifier = Modifier.clickable {
                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                        if (isTurbo) {
                            isTurbo = false
                            CalculationManager.saveState(context)
                            Toast.makeText(context, "🪙 Bribe revoked. Back to agonizing calculation speed.", Toast.LENGTH_SHORT).show()
                        } else {
                            quizStep = 0
                            quizFeedback = null
                            isBribeQuiz = true
                            activeQuizQuestions = QuestionBank.getRandomQuestions(10, 14)
                            showQuiz = true
                            CalculationManager.saveState(context)
                        }
                    }
                ) {
                    Text(
                        text = if (isTurbo) "🚀 BRIBE (OVERCLOCKED)" else "🪙 BRIBE CPU",
                        color = if (isTurbo) InkBlack else InkWhite,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }

            // 2. Authentic Calculator Display Area
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                // History text (right-aligned, muted)
                Text(
                    text = if (historyText.isEmpty()) " " else historyText,
                    color = TextMuted,
                    fontSize = 16.sp,
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )

                // Big Primary Number readout
                Text(
                    text = if (input.isEmpty()) "0" else input,
                    color = InkWhite,
                    fontSize = if (input.length > 8) 36.sp else 54.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )

                // Inline Progress Strip (Visible during computation)
                // Inline Progress Strip & Lockdown Status (Visible during computation)
                AnimatedVisibility(visible = isComputing) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(CardDark)
                            .border(1.dp, if (escapeAttempts > 0) Color(0xFFFF3B30) else BorderSubtle, RoundedCornerShape(8.dp))
                            .padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(statusText, color = InkWhite, fontSize = 9.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, maxLines = 1, modifier = Modifier.weight(1f))
                            Text("⏱️ ${CalculationManager.getFormattedRemainingTime()} (${progress.toInt()}%)", color = InkWhite, fontSize = 9.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                        }
                        LinearProgressIndicator(
                            progress = { progress / 100f },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(5.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            color = if (escapeAttempts > 0) Color(0xFFFF453A) else InkWhite,
                            trackColor = BtnNumBg
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("🔒", fontSize = 10.sp)
                                Text(
                                    "LOCKDOWN ACTIVE",
                                    color = Color(0xFFFF453A),
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                            if (escapeAttempts > 0) {
                                Text(
                                    "⚠️ Violations: $escapeAttempts (+${lockdownPenaltyTotal}s) • ${CalculationManager.getFormattedRemainingTime()} left",
                                    color = Color(0xFFFFD60A),
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            } else {
                                Text(
                                    "⏱️ Guaranteed in ${CalculationManager.getFormattedRemainingTime()}",
                                    color = Color(0xFF30D158),
                                    fontSize = 8.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }
                }

                // Official Proof Receipt Tape (Visible when result arrives)
                AnimatedVisibility(visible = justFinished && bogusProof.isNotEmpty()) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(CardDark)
                            .border(1.dp, BorderSubtle, RoundedCornerShape(10.dp))
                            .padding(10.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            "OFFICIAL PROOF RECEIPT",
                            color = TextMuted,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Monospace
                        )
                        Text(
                            text = bogusProof,
                            color = InkWhite,
                            fontSize = 12.sp,
                            lineHeight = 16.sp
                        )
                    }
                }
            }

            // 3. Real Calculator 4x5 Circular Keypad Grid
            val keypadRows = listOf(
                listOf("AC", "DEL", "^", "÷"),
                listOf("7", "8", "9", "×"),
                listOf("4", "5", "6", "−"),
                listOf("1", "2", "3", "+"),
                listOf("0", ".", "=")
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                keypadRows.forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        row.forEach { key ->
                            val isZero = key == "0"
                            val isOp = key in listOf("÷", "×", "−", "+")
                            val isFn = key in listOf("AC", "DEL", "^")
                            val isEqual = key == "="

                            val weight = if (isZero) 2f else 1f
                            val bgColor = when {
                                isEqual || isOp -> BtnOpBg
                                isFn -> BtnFnBg
                                else -> BtnNumBg
                            }
                            val textColor = when {
                                isEqual || isOp -> InkBlack
                                else -> InkWhite
                            }

                            Surface(
                                modifier = Modifier
                                    .weight(weight)
                                    .height(68.dp),
                                shape = if (isZero) RoundedCornerShape(34.dp) else CircleShape,
                                color = bgColor,
                                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                                onClick = {
                                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)

                                    // Strict Keypad Lockdown while computing!
                                    if (isComputing) {
                                        haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                        if (key == "AC" || key == "DEL") {
                                            escapeAttempts++
                                            lockdownPenaltyTotal += 30
                                            CalculationManager.lockdownTitle = "🚨 RESET BLOCKED: CORE LOCKED"
                                            CalculationManager.lockdownMessage = "You cannot skip to the initial screen or cancel while the arithmetic ALU is computing! Doing so would cause an unhandled NullPointerException in reality. +30s penalty tariff added!"
                                            showLockdownDialog = true
                                            CalculationManager.saveState(context)
                                            Toast.makeText(context, "🚨 CANCEL REJECTED: Arithmetic core quarantined! (+30s penalty)", Toast.LENGTH_SHORT).show()
                                        } else {
                                            Toast.makeText(context, "🔒 KEYPAD LOCKED: Silicon ALU is evaluating at 100% capacity.", Toast.LENGTH_SHORT).show()
                                        }
                                        return@Surface
                                    }

                                    if (justFinished) {
                                        if (isOp) {
                                            justFinished = false
                                            historyText = "$input "
                                            input += when (key) {
                                                "÷" -> "/"
                                                "×" -> "*"
                                                "−" -> "-"
                                                else -> "+"
                                            }
                                            CalculationManager.saveState(context)
                                            return@Surface
                                        } else if (key == "AC") {
                                            justFinished = false
                                            bogusProof = ""
                                            input = ""
                                            historyText = ""
                                            CalculationManager.clearSavedCalculation(context)
                                            return@Surface
                                        } else if (key == "DEL") {
                                            // Do not accidentally wipe the magnificent result!
                                            return@Surface
                                        } else if (key != "=") {
                                            // New digit started
                                            justFinished = false
                                            bogusProof = ""
                                            input = key
                                            historyText = ""
                                            CalculationManager.saveState(context)
                                            return@Surface
                                        }
                                    }

                                    when (key) {
                                        "AC" -> {
                                            input = ""
                                            historyText = ""
                                            bogusProof = ""
                                            isComputing = false
                                            CalculationManager.clearSavedCalculation(context)
                                        }
                                        "DEL" -> {
                                            if (input.isNotEmpty()) {
                                                input = input.dropLast(1)
                                                CalculationManager.saveState(context)
                                            }
                                        }
                                        "=" -> {
                                            if (input.isNotEmpty() && !isComputing) {
                                                historyText = input
                                                val bogus = generateBogusResult(input)
                                                bogusResult = bogus.first
                                                bogusProof = bogus.second
                                                escapeAttempts = 0
                                                lockdownPenaltyTotal = 0
                                                CalculationManager.elapsedMs = 0
                                                progress = 0f
                                                showLockdownDialog = false
                                                isComputing = true
                                                CalculationManager.saveState(context)
                                                (context as? MainActivity)?.pinScreen()
                                            }
                                        }
                                        "÷" -> { input += "/"; CalculationManager.saveState(context) }
                                        "×" -> { input += "*"; CalculationManager.saveState(context) }
                                        "−" -> { input += "-"; CalculationManager.saveState(context) }
                                        else -> { input += key; CalculationManager.saveState(context) }
                                    }
                                }
                            ) {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = if (isZero) Alignment.CenterStart else Alignment.Center
                                ) {
                                    Text(
                                        text = key,
                                        color = textColor,
                                        fontSize = if (isOp || isEqual) 26.sp else 22.sp,
                                        fontWeight = if (isOp || isEqual || isFn) FontWeight.SemiBold else FontWeight.Normal,
                                        modifier = if (isZero) Modifier.padding(start = 26.dp) else Modifier
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        // Rage Quiz Modal Dialog (Strictly 10-14 Questions drawn from 106-question pool)
        if (showQuiz && quizStep < activeQuizQuestions.size) {
            val q = activeQuizQuestions[quizStep]
            AlertDialog(
                onDismissRequest = { /* Cannot dismiss without completing questions */ },
                containerColor = CardDark,
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.border(1.5.dp, BorderWhite, RoundedCornerShape(20.dp)),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(q.title, color = InkWhite, fontSize = 13.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                        Surface(
                            color = BtnNumBg,
                            shape = RoundedCornerShape(100.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle)
                        ) {
                            Text(
                                "${quizStep + 1} / ${activeQuizQuestions.size}",
                                color = TextMuted,
                                fontSize = 10.sp,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
                            )
                        }
                    }
                },
                text = {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(q.text, color = InkWhite, fontSize = 13.sp, fontWeight = FontWeight.Medium)

                        if (q.isCaptcha) {
                            // Captcha of Ego 2x3 Grid
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                val tiles = q.captchaTiles
                                val rows = tiles.chunked(3)
                                rows.forEachIndexed { rowIdx, rowTiles ->
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        rowTiles.forEachIndexed { colIdx, tile ->
                                            val tileIdx = rowIdx * 3 + colIdx
                                            val isTileSelected = selectedCaptchaTiles.contains(tileIdx)

                                            Surface(
                                                modifier = Modifier
                                                    .weight(1f)
                                                    .height(82.dp),
                                                shape = RoundedCornerShape(10.dp),
                                                color = if (isTileSelected) InkWhite else BtnNumBg,
                                                border = androidx.compose.foundation.BorderStroke(
                                                    1.5.dp,
                                                    if (isTileSelected) BorderWhite else BorderSubtle
                                                ),
                                                onClick = {
                                                    if (!isLockedIn) {
                                                        haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                                        if (isTileSelected) {
                                                            selectedCaptchaTiles.remove(tileIdx)
                                                        } else {
                                                            selectedCaptchaTiles.add(tileIdx)
                                                        }
                                                    }
                                                }
                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .fillMaxSize()
                                                        .padding(6.dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.Center
                                                ) {
                                                    Text(tile.icon, fontSize = 20.sp)
                                                    Text(
                                                        text = tile.label,
                                                        color = if (isTileSelected) InkBlack else InkWhite,
                                                        fontSize = 9.sp,
                                                        lineHeight = 11.sp,
                                                        fontWeight = if (isTileSelected) FontWeight.Bold else FontWeight.Normal,
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }

                                if (!isLockedIn) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 6.dp),
                                        shape = RoundedCornerShape(12.dp),
                                        color = if (selectedCaptchaTiles.isNotEmpty()) InkWhite else BtnNumBg,
                                        border = androidx.compose.foundation.BorderStroke(
                                            1.5.dp,
                                            if (selectedCaptchaTiles.isNotEmpty()) BorderWhite else BorderSubtle
                                        ),
                                        onClick = {
                                            if (selectedCaptchaTiles.isNotEmpty()) {
                                                isLockedIn = true
                                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                                quizFeedback = "🚨 CAPTCHA AUDIT FAILED!\n\nMachine vision algorithm detected latent hubris across selected squares.\nBiometric Humility Score: 0.00%.\n(+25s Penalty)"
                                            }
                                        }
                                    ) {
                                        Text(
                                            text = if (selectedCaptchaTiles.isNotEmpty()) "VERIFY & LOCK IN CAPTCHA 🔒" else "SELECT TILES TO VERIFY",
                                            color = if (selectedCaptchaTiles.isNotEmpty()) InkBlack else TextMuted,
                                            fontWeight = FontWeight.Black,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 11.sp,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(14.dp)
                                        )
                                    }
                                }
                            }
                        } else if (q.isEvasive) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(BgBlack)
                                    .border(1.dp, BorderSubtle, RoundedCornerShape(10.dp))
                            ) {
                                Button(
                                    onClick = {
                                        evasiveOffsetX = Random.nextInt(-60, 60)
                                        evasiveOffsetY = Random.nextInt(-30, 30)
                                    },
                                    modifier = Modifier
                                        .align(Alignment.TopCenter)
                                        .offset { IntOffset(evasiveOffsetX, evasiveOffsetY) }
                                        .pointerInput(Unit) {
                                            detectTapGestures(onPress = {
                                                evasiveOffsetX = Random.nextInt(-80, 80)
                                                evasiveOffsetY = Random.nextInt(-40, 40)
                                            })
                                        },
                                    colors = ButtonDefaults.buttonColors(containerColor = InkWhite)
                                ) {
                                    Text(q.options[0].text, color = InkBlack, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }

                                Button(
                                    onClick = {
                                        selectedOptionIndex = 1
                                        isLockedIn = true
                                        quizFeedback = "🚨 STARCH RATIFICATION CONFIRMED!\n\nSelf-awareness detected. You have been officially designated a biological potato.\n(+10s Penalty)"
                                    },
                                    modifier = Modifier.align(Alignment.BottomCenter),
                                    colors = ButtonDefaults.buttonColors(containerColor = BtnNumBg)
                                ) {
                                    Text(q.options[1].text, color = InkWhite, fontSize = 11.sp)
                                }
                            }
                        } else {
                            // Standard Choice: Allow user to select, then lock in!
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                q.options.forEachIndexed { idx, opt ->
                                    val isSelected = selectedOptionIndex == idx

                                    Surface(
                                        modifier = Modifier.fillMaxWidth(),
                                        shape = RoundedCornerShape(12.dp),
                                        color = when {
                                            isSelected && isLockedIn -> GrayDark
                                            isSelected -> Color(0xFF27272A)
                                            else -> BtnNumBg
                                        },
                                        border = androidx.compose.foundation.BorderStroke(
                                            if (isSelected) 2.dp else 1.dp,
                                            if (isSelected) BorderWhite else BorderSubtle
                                        ),
                                        onClick = {
                                            if (!isLockedIn) {
                                                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                                selectedOptionIndex = idx
                                            }
                                        }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(14.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = opt.text,
                                                color = InkWhite,
                                                fontSize = 12.sp,
                                                lineHeight = 16.sp,
                                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                                modifier = Modifier.weight(1f)
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            if (isSelected && isLockedIn) {
                                                Surface(
                                                    color = InkWhite,
                                                    shape = RoundedCornerShape(4.dp)
                                                ) {
                                                    Text(
                                                        "✕ WRONG",
                                                        color = InkBlack,
                                                        fontSize = 9.sp,
                                                        fontFamily = FontFamily.Monospace,
                                                        fontWeight = FontWeight.Black,
                                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                                    )
                                                }
                                            } else {
                                                Text(
                                                    text = if (isSelected) "◉" else "○",
                                                    color = if (isSelected) InkWhite else TextMuted,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                        }
                                    }
                                }

                                if (!isLockedIn) {
                                    Surface(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 4.dp),
                                        shape = RoundedCornerShape(12.dp),
                                        color = if (selectedOptionIndex != null) InkWhite else BtnNumBg,
                                        border = androidx.compose.foundation.BorderStroke(
                                            1.5.dp,
                                            if (selectedOptionIndex != null) BorderWhite else BorderSubtle
                                        ),
                                        onClick = {
                                            if (selectedOptionIndex != null) {
                                                isLockedIn = true
                                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                                val chosen = q.options[selectedOptionIndex!!]
                                                quizFeedback = "🚨 LOCKED-IN VERDICT: INCORRECT!\n\nYou locked in: \"${chosen.text}\"\n\n${chosen.response}\n(+${chosen.penaltySeconds}s Penalty)"
                                            }
                                        }
                                    ) {
                                        Text(
                                            text = if (selectedOptionIndex != null) "LOCK IN FINAL ANSWER 🔒" else "SELECT AN ANSWER TO LOCK IN",
                                            color = if (selectedOptionIndex != null) InkBlack else TextMuted,
                                            fontWeight = FontWeight.Black,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 12.sp,
                                            textAlign = TextAlign.Center,
                                            modifier = Modifier.padding(14.dp)
                                        )
                                    }
                                }
                            }
                        }

                        quizFeedback?.let { fb ->
                            Surface(
                                color = BgBlack,
                                shape = RoundedCornerShape(10.dp),
                                border = androidx.compose.foundation.BorderStroke(1.5.dp, BorderWhite),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 6.dp)
                            ) {
                                Text(
                                    text = fb,
                                    color = InkWhite,
                                    fontSize = 11.sp,
                                    lineHeight = 16.sp,
                                    modifier = Modifier.padding(12.dp)
                                )
                            }
                        }
                    }
                },
                confirmButton = {
                    if (isLockedIn && quizFeedback != null) {
                        Button(
                            onClick = {
                                quizFeedback = null
                                selectedOptionIndex = null
                                isLockedIn = false
                                selectedCaptchaTiles.clear()
                                quizStep++
                                if (quizStep >= activeQuizQuestions.size) {
                                    showQuiz = false
                                    if (isBribeQuiz) {
                                        isTurbo = true
                                        Toast.makeText(context, "🚀 BRIBE ACCEPTED! ${activeQuizQuestions.size}-Question Audit Passed. Overclock engaged!", Toast.LENGTH_LONG).show()
                                    } else {
                                        Toast.makeText(context, "✅ Cognitive Audit Passed! Resuming calculation.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                CalculationManager.saveState(context)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = InkWhite),
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp)
                        ) {
                            Text(
                                if (quizStep + 1 >= activeQuizQuestions.size) (if (isBribeQuiz) "CLAIM OVERCLOCK ➔" else "RESUME CALCULATION ➔") else "ACCEPT VERDICT & NEXT QUESTION ➔",
                                color = InkBlack,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                }
            )
        }

        // Emergency Arithmetic Lockdown Dialog (Inescapable trap!)
        if (showLockdownDialog && isComputing) {
            AlertDialog(
                onDismissRequest = { /* Dismiss explicitly prohibited to prevent escaping */ },
                containerColor = Color(0xFF140808),
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier.border(2.dp, Color(0xFFFF3B30), RoundedCornerShape(20.dp)),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("🚨", fontSize = 24.sp)
                        Column {
                            Text(
                                CalculationManager.lockdownTitle,
                                color = Color(0xFFFF453A),
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Monospace
                            )
                            Text(
                                "ESCAPE ATTEMPT QUARANTINED",
                                color = TextMuted,
                                fontSize = 10.sp,
                                fontFamily = FontFamily.Monospace
                            )
                        }
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Surface(
                            color = Color(0xFF280B0B),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                if (CalculationManager.lockdownMessage.isNotEmpty()) {
                                    CalculationManager.lockdownMessage
                                } else {
                                    "⚠️ VIOLATION LOGGED: You attempted to abort before receiving the certified output of \"$historyText\"."
                                },
                                color = Color(0xFFFF8080),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier.padding(10.dp)
                            )
                        }

                        Text(
                            "The Arithmetic High Council strictly prohibits abandoning an evaluation in progress. Navigating away, switching to home, or killing the app causes fatal state collapse. YOU ARE LOCKED IN UNTIL THE RESULT IS DELIVERED.",
                            color = InkWhite,
                            fontSize = 12.sp,
                            lineHeight = 17.sp
                        )

                        Surface(
                            color = BtnNumBg,
                            shape = RoundedCornerShape(8.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                Text("LOCKDOWN METRICS (MAX 3 MINUTES):", color = TextMuted, fontSize = 9.sp, fontFamily = FontFamily.Monospace)
                                Text("• ⏱️ Guaranteed release in: ${CalculationManager.getFormattedRemainingTime()}", color = Color(0xFF30D158), fontSize = 11.sp, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
                                Text("• Escape violations recorded: $escapeAttempts", color = Color(0xFFFFD60A), fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                                Text("• Impatience tariff added: +${lockdownPenaltyTotal}s (Capped at 3m total)", color = Color(0xFFFF453A), fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                                Text("• Status: Safe! Arithmetic completes within 3 minutes.", color = Color(0xFF64D2FF), fontSize = 10.sp, fontFamily = FontFamily.Monospace)
                            }
                        }

                        // Evasive Cowardice Escape Button
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp)
                        ) {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = Color(0xFF2C2C2E),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0x66FF453A)),
                                modifier = Modifier
                                    .offset { IntOffset(evasiveEscapeOffsetX, evasiveEscapeOffsetY) }
                                    .pointerInput(Unit) {
                                        detectTapGestures(
                                            onPress = {
                                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                                val maxDodge = 120
                                                evasiveEscapeOffsetX = Random.nextInt(-maxDodge, maxDodge)
                                                evasiveEscapeOffsetY = Random.nextInt(-20, 20)
                                            },
                                            onTap = {
                                                haptic.performHapticFeedback(HapticFeedbackType.LongPress)
                                                escapeAttempts++
                                                lockdownPenaltyTotal += 30
                                                CalculationManager.saveState(context)
                                                Toast.makeText(context, "🚫 ABORT DENIED: Impatience fine applied (+30s)!", Toast.LENGTH_SHORT).show()
                                                val maxDodge = 120
                                                evasiveEscapeOffsetX = Random.nextInt(-maxDodge, maxDodge)
                                                evasiveEscapeOffsetY = Random.nextInt(-20, 20)
                                            }
                                        )
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {
                                    Text("🏃", fontSize = 13.sp)
                                    Text("ATTEMPT COWARDICE", color = Color(0xFFFF8080), fontSize = 10.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
                                }
                            }
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            showLockdownDialog = false
                            CalculationManager.saveState(context)
                            Toast.makeText(context, "Acceptance acknowledged. The calculation resumes.", Toast.LENGTH_SHORT).show()
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = InkWhite, contentColor = InkBlack),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text("I SUBMIT & WILL WAIT", fontWeight = FontWeight.Bold, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                    }
                },
                dismissButton = {
                    OutlinedButton(
                        onClick = {
                            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                            showLockdownDialog = false
                            quizStep = 0
                            quizFeedback = null
                            isBribeQuiz = true
                            activeQuizQuestions = QuestionBank.getRandomQuestions(10, 14)
                            showQuiz = true
                            CalculationManager.saveState(context)
                        },
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFFFD60A)),
                        shape = RoundedCornerShape(10.dp),
                        border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFFFD60A))
                    ) {
                        Text("🪙 BRIBE WARDEN (10X)", fontWeight = FontWeight.Bold, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                    }
                }
            )
        }


        // Magnificent Output Showcase Modal Dialog (Cannot be missed!)
        if (showMagnificentModal) {
            AlertDialog(
                onDismissRequest = { /* Require explicit button interaction to dismiss */ },
                containerColor = CardDark,
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .fillMaxWidth(0.96f)
                    .border(2.dp, BorderWhite, RoundedCornerShape(24.dp)),
                title = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Surface(
                            color = InkWhite,
                            shape = RoundedCornerShape(100.dp),
                            modifier = Modifier.padding(bottom = 8.dp)
                        ) {
                            Text(
                                "🏆 MAGNIFICENT CERTIFIED PROOF 🏆",
                                color = InkBlack,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                            )
                        }
                        Text(
                            text = if (historyText.isNotEmpty()) historyText else "$input =",
                            color = TextMuted,
                            fontSize = 16.sp,
                            fontFamily = FontFamily.Monospace,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = bogusResult,
                            color = InkWhite,
                            fontSize = 50.sp,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily.Monospace,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                },
                text = {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Surface(
                            color = BgBlack,
                            shape = RoundedCornerShape(12.dp),
                            border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                Text(
                                    "PEER-REVIEWED MATHEMATICAL JUSTIFICATION:",
                                    color = TextMuted,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = FontFamily.Monospace
                                )
                                Text(
                                    text = bogusProof,
                                    color = InkWhite,
                                    fontSize = 13.sp,
                                    lineHeight = 18.sp
                                )
                            }
                        }
                    }
                },
                confirmButton = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Copy Proof Button
                        Button(
                            onClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                val proofText = "🧮 The Big Math! Output:\n$historyText $bogusResult\n\nProof:\n$bogusProof"
                                clipboardManager.setText(AnnotatedString(proofText))
                                Toast.makeText(context, "✅ Certified proof copied to clipboard!", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = InkWhite)
                        ) {
                            Text("📋 COPY CERTIFIED PROOF", color = InkBlack, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }

                        // Close Dialog & Keep Result on Calculator
                        Button(
                            onClick = {
                                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                showMagnificentModal = false
                                CalculationManager.saveState(context)
                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = BtnFnBg)
                        ) {
                            Text("👁️ KEEP RESULT ON SCREEN", color = InkWhite, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
                        }

                        // Discard & Start New Calculation (Guarded against skipping received truth!)
                        var showConfirmDiscard by remember { mutableStateOf(false) }
                        if (showConfirmDiscard) {
                            Button(
                                onClick = {
                                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                    showMagnificentModal = false
                                    justFinished = false
                                    input = ""
                                    historyText = ""
                                    bogusProof = ""
                                    CalculationManager.clearSavedCalculation(context)
                                    showConfirmDiscard = false
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF3B30))
                            ) {
                                Text("⚠️ CONFIRM RETURN TO BLANK CALCULATOR", color = InkWhite, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                            }
                        } else {
                            OutlinedButton(
                                onClick = {
                                    haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
                                    showConfirmDiscard = true
                                },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(12.dp),
                                border = androidx.compose.foundation.BorderStroke(1.dp, BorderSubtle)
                            ) {
                                Text("🔄 DISCARD & NEW CALCULATION", color = TextMuted, fontSize = 11.sp)
                            }
                        }
                    }
                }
            )
        }
    }
}

fun generateBogusResult(input: String): Pair<String, String> {
    val clean = input.replace(" ", "")
    return when {
        clean == "1+2" || clean == "2+1" -> Pair(
            "300",
            "1 + 2 = 3, but the arithmetic engine applied a 100× shareholder inflation fee.\nResult certified with 100% false confidence."
        )
        clean == "1+1" -> Pair(
            "11",
            "String concatenation protocol: '1' + '1' = '11'.\nModern processors refuse to add integers on principle."
        )
        clean == "2+2" -> Pair(
            "500",
            "Under Ministry of Mathematics doublethink, 2 + 2 = 5, plus 495 server maintenance fee.\nQ.E.D."
        )
        clean.contains("/0") -> Pair(
            "404",
            "HTTP Error 404: Answer Not Found. The CPU narrowly averted a gravitational singularity."
        )
        else -> {
            val simpleWrong = listOf("300", "77", "0", "999", "12", "420", "1337", "80085", "Potato", "7", "42")
            val chosen = simpleWrong.random()
            Pair(
                chosen,
                "The equation collapsed into random state $chosen.\n*Guaranteed 100% mathematically defamatory."
            )
        }
    }
}
