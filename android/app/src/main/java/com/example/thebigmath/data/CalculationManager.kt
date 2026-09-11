package com.example.thebigmath.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object CalculationManager {
    private const val PREFS_NAME = "the_big_math_lockdown_prefs"
    private var prefs: SharedPreferences? = null

    // Reactive Compose States
    var input by mutableStateOf("")
    var historyText by mutableStateOf("")
    var isComputing by mutableStateOf(false)
    var isTurbo by mutableStateOf(false)
    var justFinished by mutableStateOf(false)
    var showMagnificentModal by mutableStateOf(false)

    var progress by mutableFloatStateOf(0f)
    var statusText by mutableStateOf("INITIALIZING DEEP-THINK SILICON KERNEL...")
    var bogusResult by mutableStateOf("")
    var bogusProof by mutableStateOf("")
    var elapsedMs by mutableIntStateOf(0)

    // Lockdown States
    var showLockdownDialog by mutableStateOf(false)
    var lockdownTitle by mutableStateOf("🚨 ARITHMETIC LOCKDOWN")
    var lockdownMessage by mutableStateOf("")
    var escapeAttempts by mutableIntStateOf(0)
    var lockdownPenaltyTotal by mutableIntStateOf(0)
    var homeEvasionAttempted by mutableStateOf(false)

    // Quiz States
    var showQuiz by mutableStateOf(false)
    var isBribeQuiz by mutableStateOf(false)
    var quizStep by mutableIntStateOf(0)

    const val MAX_CALCULATION_DURATION_MS = 180000 // 3 minutes maximum guarantee!
    const val NORMAL_BASE_DURATION_MS = 90000      // 1.5 minutes standard
    const val TURBO_BASE_DURATION_MS = 25000       // 25s overclocked

    fun getRemainingSeconds(): Int {
        val base = if (isTurbo) TURBO_BASE_DURATION_MS else NORMAL_BASE_DURATION_MS
        val total = (base + (lockdownPenaltyTotal * 1000)).coerceAtMost(MAX_CALCULATION_DURATION_MS)
        val remaining = (total - elapsedMs).coerceAtLeast(0)
        return (remaining / 1000)
    }

    fun getFormattedRemainingTime(): String {
        val totalSec = getRemainingSeconds()
        val m = totalSec / 60
        val s = totalSec % 60
        return String.format("%02d:%02d", m, s)
    }

    fun init(context: Context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val sp = prefs ?: return

        val wasComputing = sp.getBoolean("is_computing", false)
        if (wasComputing) {
            input = sp.getString("input", "") ?: ""
            historyText = sp.getString("history_text", "") ?: ""
            progress = sp.getFloat("progress", 0f)
            elapsedMs = sp.getInt("elapsed_ms", 0)
            escapeAttempts = sp.getInt("escape_attempts", 0) + 1
            lockdownPenaltyTotal = (sp.getInt("penalty_total", 0) + 20).coerceAtMost(90)
            bogusResult = sp.getString("bogus_result", "") ?: ""
            bogusProof = sp.getString("bogus_proof", "") ?: ""
            isTurbo = sp.getBoolean("is_turbo", false)

            isComputing = true
            showLockdownDialog = true
            lockdownTitle = "🚨 PERSISTENT QUANTUM LOCKDOWN"
            lockdownMessage = "Did you try to skip by navigating away or killing the app?\n\nThe Big Math does not forget! 64TB of virtual arithmetic registers were retrieved from NVRAM.\n\nDon't worry, the calculation is guaranteed to release within 3 minutes maximum!"
            saveState(context)
        } else {
            val wasFinished = sp.getBoolean("just_finished", false)
            if (wasFinished) {
                input = sp.getString("input", "") ?: ""
                historyText = sp.getString("history_text", "") ?: ""
                bogusResult = sp.getString("bogus_result", "") ?: ""
                bogusProof = sp.getString("bogus_proof", "") ?: ""
                justFinished = true
            }
        }
    }

    fun saveState(context: Context) {
        val sp = prefs ?: context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sp.edit().apply {
            putBoolean("is_computing", isComputing)
            putString("input", input)
            putString("history_text", historyText)
            putFloat("progress", progress)
            putInt("elapsed_ms", elapsedMs)
            putInt("escape_attempts", escapeAttempts)
            putInt("penalty_total", lockdownPenaltyTotal)
            putString("bogus_result", bogusResult)
            putString("bogus_proof", bogusProof)
            putBoolean("is_turbo", isTurbo)
            putBoolean("just_finished", justFinished)
            apply()
        }
    }

    fun onUserAttemptedHome(activity: Activity) {
        if (isComputing) {
            escapeAttempts++
            lockdownPenaltyTotal = (lockdownPenaltyTotal + 15).coerceAtMost(90)
            homeEvasionAttempted = true
            saveState(activity)
        }
    }

    fun onActivityResumed(activity: Activity) {
        if (isComputing && homeEvasionAttempted) {
            homeEvasionAttempted = false
            showLockdownDialog = true
            lockdownTitle = "🚨 HOME PAGE EVASION INTERCEPTED!"
            lockdownMessage = "You attempted to flee to your device's home screen!\n\nThe Silicon ALU intercepted the flight and preserved all registers.\n\nRelax! Guaranteed release in ${getFormattedRemainingTime()}."
            saveState(activity)
        }
    }


    fun clearSavedCalculation(context: Context) {
        val sp = prefs ?: context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        sp.edit().clear().apply()
    }
}
