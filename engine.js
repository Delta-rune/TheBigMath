// The Big Math! - Absurd Computation & Outrageous Equation Engine
// Authentic Calculator Experience

class BigMathEngine {
  constructor() {
    this.currentInput = '';
    this.isComputing = false;
    this.isTurbo = false;
    this.totalDurationMs = 120000; // 2 minutes standard
    this.elapsedMs = 0;
    this.progress = 0;
    this.computeInterval = null;
    this.quizTriggered = false;
    this.quizFinished = false;
    this.justFinished = false;
    this.currentCalculation = null;

    this.telemetryLogs = [
      "Initialising Deep-Think Core v11.9...",
      "Translating input to Sumerian Cuneiform...",
      "Submitting computation grant application...",
      "Grant approved ($4.2M). Allocating 64TB VRAM...",
      "Consulting Pythagoras via Ouija daemon...",
      "Pythagoras responded: 'Beans are evil'...",
      "Calculating relativistic time dilation...",
      "ALU 4 reports floating point emotional instability...",
      "Deploying 700B parameter neural net to add numbers...",
      "AI hallucinated a lemon meringue pie. Retrying...",
      "Pouring virtual liquid nitrogen on ALU...",
      "Recalibrating quantum vacuum fluctuations...",
      "Forgot to carry the zero. Recalculating...",
      "Asking ChatGPT for moral permission to divide...",
      "Submitting justification paper to Nature Math...",
      "Applying Heisenberg Uncertainty to answer...",
      "Consulting tax accountant for mathematical deductions...",
      "Finalizing output with 128.4% bogus confidence..."
    ];
  }

  appendInput(char) {
    if (this.isComputing) {
      if (char === 'C' || char === 'DEL') {
        this.showEscapeTrap();
      }
      return;
    }
    if (window.soundEngine) window.soundEngine.playClick();

    const isOp = ['+', '-', '*', '/', '^'].includes(char);

    // If user just got an answer and presses something new
    if (this.justFinished) {
      if (isOp && this.currentCalculation) {
        // Continue calculation with previous magnificent fake answer
        this.currentInput = `${this.currentCalculation.answer}${char}`;
        this.justFinished = false;
        this.updateDisplay();
        return;
      } else if (char === 'C') {
        this.resetCalculator();
        return;
      } else if (char === 'DEL') {
        // Prevent accidental erasure of the magnificent output
        return;
      } else {
        // Fresh number entered
        this.hideProof();
        this.currentInput = char;
        this.justFinished = false;
        this.updateDisplay();
        return;
      }
    }

    if (char === 'C') {
      this.currentInput = '';
      this.hideProof();
      const histEl = document.getElementById('calcHistory');
      if (histEl) histEl.innerHTML = '&nbsp;';
    } else if (char === 'DEL') {
      this.currentInput = this.currentInput.slice(0, -1);
    } else {
      // Avoid duplicate operators
      const lastChar = this.currentInput.slice(-1);
      if (isOp && ['+', '-', '*', '/', '^'].includes(lastChar)) {
        this.currentInput = this.currentInput.slice(0, -1) + char;
      } else {
        this.currentInput += char;
      }
    }
    this.updateDisplay();
  }

  hideEscapeTrap() {
    const modal = document.getElementById('escapeTrapModal');
    if (modal) modal.classList.add('hidden');
  }

  updateDisplay() {
    const inputEl = document.getElementById('calcInput');
    if (inputEl) {
      // Format display with pretty operators
      const formatted = (this.currentInput || '0')
        .replace(/\*/g, ' × ')
        .replace(/\//g, ' ÷ ')
        .replace(/\+/g, ' + ')
        .replace(/-/g, ' − ');
      inputEl.textContent = formatted;
    }
  }

  hideProof() {
    const proofEl = document.getElementById('proofReceipt');
    if (proofEl) proofEl.classList.add('hidden');
  }

  setTurbo(enabled) {
    this.isTurbo = enabled;
    const turboBtn = document.getElementById('turboToggle');
    const strip = document.getElementById('bribeReminderStrip');
    if (turboBtn) {
      if (this.isTurbo) {
        turboBtn.classList.remove('bribe-hint-pulse');
        turboBtn.classList.add('bribe-active');
        turboBtn.textContent = '🚀 BRIBE (10X)';
        if (strip) strip.classList.add('hidden');
      } else {
        turboBtn.classList.remove('bribe-active');
        turboBtn.textContent = '🪙 BRIBE';
        if (this.isComputing && strip) strip.classList.remove('hidden');
      }
    }
  }

  showEscapeTrap(customTitle, customMessage) {
    const trapModal = document.getElementById('escapeTrapModal');
    if (!trapModal) return;
    trapModal.classList.remove('hidden');
    if (window.soundEngine) window.soundEngine.playBuzzer();

    const titleEl = trapModal.querySelector('.quiz-title');
    const descEl = trapModal.querySelector('.quiz-question-text');
    if (titleEl && customTitle) titleEl.textContent = customTitle;
    if (descEl && customMessage) descEl.innerHTML = customMessage;

    const bribeBtn = document.getElementById('trapBribeBtn');
    const surrenderBtn = document.getElementById('trapSurrenderBtn');

    if (bribeBtn) {
      bribeBtn.onclick = () => {
        trapModal.classList.add('hidden');
        this.triggerBribeQuiz();
      };
    }

    if (surrenderBtn) {
      surrenderBtn.onclick = () => {
        trapModal.classList.add('hidden');
        this.setStatusText("🫡 Resuming wait. The CPU commends your compliance.");
        if (window.soundEngine) window.soundEngine.playBeep(440, 0.1);
      };
    }
  }

  triggerBribeQuiz() {
    if (this.isTurbo) {
      this.setTurbo(false);
      this.setStatusText("🪙 Bribe revoked. Back to agonizing 1× speed.");
      if (window.soundEngine) window.soundEngine.playBeep(330, 0.15);
      return;
    }

    const modal = document.getElementById('quizModal');
    const quizBody = document.getElementById('quizBody');
    if (!modal || !quizBody) return;

    modal.classList.remove('hidden');

    // Pick 5 to 10 questions from the 100+ master question bank
    const randomCount = Math.floor(Math.random() * 6) + 5; // 5 to 10 questions
    const questions = window.RageQuiz.getRandomQuestions(randomCount, randomCount);

    if (window.soundEngine) window.soundEngine.playBeep(440, 0.15);

    const quiz = new window.RageQuiz(
      () => {
        // Bribe accepted
        modal.classList.add('hidden');
        this.setTurbo(true);
        this.setStatusText("🚀 BRIBE ACCEPTED! 10X TURBO OVERCLOCK ENGAGED.");
        if (window.soundEngine) window.soundEngine.playFanfare();
      },
      (penaltySeconds) => {
        if (this.isComputing) {
          this.totalDurationMs += penaltySeconds * 1000;
          this.setStatusText(`⚠️ TARIFF: +${penaltySeconds}s delay added.`);
        }
      },
      questions,
      true // isBribe = true
    );

    quiz.start(quizBody);
  }

  startComputation(isResuming = false) {
    if (this.isComputing && !isResuming) return;
    if (!this.currentInput) return;
    this.isComputing = true;
    this.justFinished = false;
    this.quizTriggered = false;
    this.quizFinished = false;

    if (!isResuming) {
      this.regressed1 = false;
      this.regressed2 = false;
      this.regressed3 = false;
      this.regressed4 = false;
      this.elapsedMs = 0;
      this.progress = 0;
    }

    this.hideProof();

    if (window.soundEngine) {
      window.soundEngine.playDialup();
      window.soundEngine.startElevatorMusic();
    }

    if (!isResuming) {
      // Standard 80-90s, strictly capped at 180s (3 minutes maximum guarantee!)
      const opCount = (this.currentInput.match(/[\+\-\*\/\^]/g) || []).length;
      const len = this.currentInput.length;
      let baseSeconds = (this.isTurbo ? 25 : 80) + (opCount * 10) + (len * 2);
      this.totalDurationMs = Math.min(180000, baseSeconds * 1000);
    }

    // Generate Outrageous Math & Guaranteed Confidently Wrong Simple Answer
    if (!this.currentCalculation) {
      this.currentCalculation = this.generateOutrageousMath(this.currentInput);
    }

    // Show computing state in display
    const histEl = document.getElementById('calcHistory');
    if (histEl) {
      histEl.textContent = `${this.currentCalculation.rawInput} = ? (QUANTUM EVALUATION)`;
    }

    const computingBar = document.getElementById('computingBar');
    if (computingBar) computingBar.classList.remove('hidden');

    // Show bribe reminder strip and pulse the BRIBE button if not already bribed
    const turboBtn = document.getElementById('turboToggle');
    const strip = document.getElementById('bribeReminderStrip');
    if (!this.isTurbo) {
      if (turboBtn) turboBtn.classList.add('bribe-hint-pulse');
      if (strip) strip.classList.remove('hidden');
    }

    this.setStatusText("INITIALIZING DEEP-THINK SILICON KERNEL...");
    this.updateProgressBar(0);

    const reminderMessages = [
      "CAN'T BEAR THE AGONY? Tap 🪙 BRIBE above to speed this up 10×!",
      "WAITING FOR 2+ MINUTES? Solve 5–10 teasers to skip this torture!",
      "DID YOU KNOW: Bribing the CPU activates 10× Turbo Overclocking!",
      "LIFE IS SHORT: Tap BRIBE to bypass the existential quantum queue!"
    ];
    let reminderIdx = 0;

    const intervalStep = 100;
    this.computeInterval = setInterval(() => {
      // 10x Turbo speed when bribed!
      const stepTime = this.isTurbo ? intervalStep * 10 : intervalStep;
      this.elapsedMs += stepTime;

      let targetProgress = Math.min(99, (this.elapsedMs / this.totalDurationMs) * 100);

      // Cruel 4-stage regressions (skipped if user bribed the CPU)
      if (!this.isTurbo) {
        if (targetProgress > 28 && targetProgress < 32 && !this.regressed1) {
          targetProgress = 12;
          this.regressed1 = true;
          this.setStatusText("⚠️ REGRESSION: Forgot to carry the 0. Progress reverted to 12%!");
          if (window.soundEngine) window.soundEngine.playBuzzer();
        }
        if (targetProgress > 52 && targetProgress < 56 && !this.regressed2) {
          targetProgress = 24;
          this.regressed2 = true;
          this.setStatusText("⚠️ REGRESSION: Riemann hypothesis unverified. Cache flushed to 24%!");
          if (window.soundEngine) window.soundEngine.playBuzzer();
        }
        if (targetProgress > 76 && targetProgress < 80 && !this.regressed3) {
          targetProgress = 46;
          this.regressed3 = true;
          this.setStatusText("⚠️ REGRESSION: Thermal throttling. Liquid nitrogen reboot (46%)!");
          if (window.soundEngine) window.soundEngine.playBuzzer();
        }
        if (targetProgress > 92 && targetProgress < 95 && !this.regressed4) {
          targetProgress = 68;
          this.regressed4 = true;
          this.setStatusText("⚠️ REGRESSION: Checking negative zero parity. Dropped to 68%!");
          if (window.soundEngine) window.soundEngine.playBuzzer();
        }
      }

      this.progress = targetProgress;
      this.updateProgressBar(this.progress);

      // Rotate bribe reminders every ~6 seconds
      if (Math.random() < 0.03 && strip && !this.isTurbo) {
        reminderIdx = (reminderIdx + 1) % reminderMessages.length;
        const textEl = document.getElementById('bribeReminderText');
        if (textEl) textEl.textContent = reminderMessages[reminderIdx];
      }

      // Telemetry log rotation in status line
      if (Math.random() < (this.isTurbo ? 0.25 : 0.04)) {
        const randomLog = this.telemetryLogs[Math.floor(Math.random() * this.telemetryLogs.length)];
        this.setStatusText(randomLog);
      }

      // Mandatory verification quiz at ~35% (only if not bribed)
      if (this.progress >= 35 && !this.quizTriggered && !this.isTurbo) {
        this.quizTriggered = true;
        this.pauseAndTriggerQuiz();
      }

      // Computation completion
      if (this.elapsedMs >= this.totalDurationMs && (this.quizFinished || this.isTurbo)) {
        this.finishComputation();
      }
    }, intervalStep);
  }

  setStatusText(msg) {
    const el = document.getElementById('computingStatusText');
    if (el) el.textContent = msg;
  }

  pauseAndTriggerQuiz() {
    this.setStatusText("🚨 MANDATORY AUDIT: COGNITIVE TAX TRIGGERED");
    const modal = document.getElementById('quizModal');
    const quizBody = document.getElementById('quizBody');
    if (modal && quizBody) {
      modal.classList.remove('hidden');
      const questions = window.RageQuiz.getRandomQuestions(5, 7);
      const quiz = new window.RageQuiz(
        () => {
          modal.classList.add('hidden');
          this.quizFinished = true;
          this.setStatusText("✅ VERIFICATION PASSED. RESUMING CALCULATION...");
        },
        (penaltySeconds) => {
          this.totalDurationMs += penaltySeconds * 1000;
          this.setStatusText(`⚠️ PENALTY: +${penaltySeconds}s added.`);
        },
        questions,
        false
      );
      quiz.start(quizBody);
    } else {
      this.quizFinished = true;
    }
  }

  finishComputation() {
    clearInterval(this.computeInterval);
    this.computeInterval = null;
    this.isComputing = false;
    this.justFinished = true;

    if (window.soundEngine) {
      window.soundEngine.stopElevatorMusic();
      window.soundEngine.playFanfare();
    }

    // Hide computing bar and strip
    const computingBar = document.getElementById('computingBar');
    if (computingBar) computingBar.classList.add('hidden');

    const strip = document.getElementById('bribeReminderStrip');
    if (strip) strip.classList.add('hidden');

    const turboBtn = document.getElementById('turboToggle');
    if (turboBtn) turboBtn.classList.remove('bribe-hint-pulse');

    // Update history and primary answer
    const histEl = document.getElementById('calcHistory');
    if (histEl) {
      histEl.textContent = `${this.currentCalculation.rawInput} =`;
    }

    const inputEl = document.getElementById('calcInput');
    if (inputEl) {
      inputEl.textContent = this.currentCalculation.answer;
      inputEl.classList.remove('animate-pop');
      void inputEl.offsetWidth; // trigger reflow
      inputEl.classList.add('animate-pop');
    }

    // Unfurl official proof receipt on calculator
    const proofBox = document.getElementById('proofReceipt');
    const proofContent = document.getElementById('proofContent');
    if (proofBox && proofContent) {
      proofContent.innerHTML = this.currentCalculation.proof;
      proofBox.classList.remove('hidden');
    }

    // Launch Magnificent Output Modal Showcase so they CANNOT miss the magnificent result!
    const magModal = document.getElementById('magnificentModal');
    const magEquation = document.getElementById('magEquation');
    const magNumber = document.getElementById('magNumber');
    const magProof = document.getElementById('magProof');
    if (magModal && magEquation && magNumber && magProof) {
      magEquation.textContent = `${this.currentCalculation.rawInput} =`;
      magNumber.textContent = this.currentCalculation.answer;
      magProof.innerHTML = this.currentCalculation.proof;
      magModal.classList.remove('hidden');
    }
  }

  generateOutrageousMath(input) {
    const expansions = [
      `\\lim_{x \\to \\infty} \\left[ \\sum_{k=1}^{\\Omega} \\left( \\frac{\\hbar \\cdot \\sqrt{-1} + (${input})}{\\oint_{\\mathcal{C}} \\nabla \\times \\vec{B} \\cdot d\\vec{A}} \\right) \\right]`,
      `\\left[ \\frac{\\zeta(3) \\times \\text{Schrödinger}(${input})}{\\Gamma(1/2) \\cdot \\ln(\\pi^{e})} \\right]^{\\aleph_0} \\pm \\delta_{\\text{uncertainty}}`,
      `\\oint_{\\partial \\Sigma} \\left( \\nabla \\cdot \\vec{E}_{(${input})} \\right) d\\tau + \\frac{\\partial^2}{\\partial t^2} \\left[ \\cos(\\pi) + \\sqrt[3]{\\text{Dark Matter}} \\right]`,
      `\\sqrt[4]{\\prod_{n=1}^{100} \\left( 1 + \\frac{1}{n^2} \\right)} \\star (${input}) \\oplus \\mathbb{E}[\\text{Dread}] \\pmod{73}`
    ];
    const chosenEquation = expansions[Math.floor(Math.random() * expansions.length)];

    let realVal = null;
    try {
      const sanitised = input.replace(/\^/g, '**').replace(/[^-()\d/*+.]/g, '');
      realVal = Function(`'use strict'; return (${sanitised})`)();
    } catch (e) {
      realVal = null;
    }

    const clean = input.replace(/\s+/g, '');
    let fakeAnswer = '300';
    let fakeProof = '';

    // Direct requested simple nonsense pairs
    if (clean === '1+2' || clean === '2+1') {
      fakeAnswer = '300';
      fakeProof = `
        <strong>Algorithm Audit:</strong><br>
        1 + 2 = 3, but the arithmetic core applied a 100× inflation multiplier.<br>
        <em>Result certified with 100% false confidence.</em>
      `;
    } else if (clean === '1+1' || clean === '1+1.0') {
      fakeAnswer = '11';
      fakeProof = `
        <strong>String Concatenation Protocol:</strong><br>
        "1" + "1" = "11". Modern JavaScript engines refuse to do arithmetic on principle.<br>
        <em>No apologies offered.</em>
      `;
    } else if (clean === '2+2') {
      fakeAnswer = '500';
      fakeProof = `
        <strong>Doublethink Axiom:</strong><br>
        2 + 2 = 5, plus 495 convenience fee.<br>
        <em>Q.E.D.</em>
      `;
    } else if (clean.includes('/0')) {
      fakeAnswer = '404';
      fakeProof = `
        <strong>HTTP Error:</strong><br>
        Division by zero returned 404: Answer Not Found in spacetime manifold.
      `;
    } else {
      const wrongPool = [];

      if (typeof realVal === 'number' && !isNaN(realVal)) {
        // Multiply by 100 (e.g. 5 -> 500)
        wrongPool.push({
          ans: `${Math.round(realVal * 100)}`,
          reason: 'Result scaled by 100× to maximize shareholder return.'
        });
        // Multiply by 10
        wrongPool.push({
          ans: `${Math.round(realVal * 10)}`,
          reason: 'A stray zero wandered into the CPU register.'
        });
        // Off by 1
        const offset = Math.random() < 0.5 ? 1 : -1;
        wrongPool.push({
          ans: `${Math.round(realVal) + offset}`,
          reason: 'ALU dropped a single bit while distracted.'
        });
        // Digit concatenation
        const digits = input.match(/\d+/g);
        if (digits && digits.length >= 2) {
          wrongPool.push({
            ans: digits.join(''),
            reason: 'Operators ignored; numbers glued side-by-side.'
          });
        }
      }

      // Classic simple random nonsense answers
      const staticNonsense = [
        { ans: '300', reason: '300 was selected by unanimous CPU decision.' },
        { ans: '77', reason: 'Rounded to lucky integer 77.' },
        { ans: '0', reason: 'The equation ran out of kinetic energy and collapsed to 0.' },
        { ans: '999', reason: 'Buffer capacity exceeded; pegged at 999.' },
        { ans: '12', reason: 'Defaulted to baker\'s dozen minus 1.' },
        { ans: '420', reason: 'Thermodynamic throttle forced answer to 420.' },
        { ans: '1337', reason: 'Processor activated Elite Hacker mode.' },
        { ans: '80085', reason: 'Classic pocket calculator memory dump.' },
        { ans: '7', reason: 'Because 7 ate 9.' },
        { ans: '1', reason: 'The universe collapsed to a single unit.' },
        { ans: '42', reason: 'Deep Thought insists this is the answer.' },
        { ans: 'Potato', reason: 'CPU starved of electricity; produced starch.' }
      ];

      const combined = [...wrongPool, ...staticNonsense];
      let pick = combined[Math.floor(Math.random() * combined.length)];

      // Strict guarantee: NEVER output the mathematically correct answer
      if (realVal !== null && (pick.ans === `${realVal}` || pick.ans === `${Math.round(realVal)}`)) {
        pick = {
          ans: `${Math.round(realVal) + 300}`,
          reason: 'Offset by +300 to maintain guaranteed 0% mathematical accuracy.'
        };
      }

      fakeAnswer = pick.ans;
      fakeProof = `
        <strong>Formal Derivation:</strong><br>
        ${pick.reason}<br>
        <em>*Guaranteed 100% incorrect.</em>
      `;
    }

    return {
      equation: chosenEquation,
      rawInput: input,
      answer: fakeAnswer,
      proof: fakeProof
    };
  }

  updateProgressBar(percent) {
    const bar = document.getElementById('calcProgressBar');
    const label = document.getElementById('calcProgressPercent');
    if (bar) bar.style.width = `${Math.max(0, Math.min(100, percent))}%`;
    const remainingMs = Math.max(0, (this.totalDurationMs || 180000) - (this.elapsedMs || 0));
    const totalSec = Math.ceil(remainingMs / 1000);
    const m = Math.floor(totalSec / 60);
    const s = totalSec % 60;
    const timeStr = `${m}:${s < 10 ? '0' : ''}${s}`;
    if (label) label.textContent = `⏱️ ${timeStr} (${Math.floor(percent)}%)`;
  }

  resetCalculator() {
    if (window.soundEngine) window.soundEngine.playClick();
    this.currentInput = '';
    this.isComputing = false;
    this.regressed1 = false;
    this.regressed2 = false;
    this.quizFinished = false;
    this.quizTriggered = false;
    this.justFinished = false;

    const histEl = document.getElementById('calcHistory');
    if (histEl) histEl.innerHTML = '&nbsp;';

    const computingBar = document.getElementById('computingBar');
    if (computingBar) computingBar.classList.add('hidden');

    this.hideProof();
    this.updateDisplay();
    localStorage.removeItem('the_big_math_saved_calc');
  }

  saveStateToStorage() {
    if (!this.isComputing) return;
    const data = {
      currentInput: this.currentInput,
      isComputing: this.isComputing,
      isTurbo: this.isTurbo,
      elapsedMs: this.elapsedMs,
      totalDurationMs: this.totalDurationMs,
      progress: this.progress,
      currentCalculation: this.currentCalculation,
      escapeAttempts: this.escapeAttempts || 0
    };
    try {
      localStorage.setItem('the_big_math_saved_calc', JSON.stringify(data));
    } catch (_) {}
  }

  restoreStateFromStorage() {
    try {
      const raw = localStorage.getItem('the_big_math_saved_calc');
      if (!raw) return;
      const data = JSON.parse(raw);
      if (data && data.isComputing) {
        this.currentInput = data.currentInput || '';
        this.isTurbo = !!data.isTurbo;
        this.elapsedMs = data.elapsedMs || 0;
        this.totalDurationMs = (data.totalDurationMs || 120000) + 45000;
        this.currentCalculation = data.currentCalculation;
        this.escapeAttempts = (data.escapeAttempts || 0) + 1;
        this.updateDisplay();

        setTimeout(() => {
          this.startComputation(true);
          this.showEscapeTrap(
            "🚨 PERSISTENT QUANTUM LOCKDOWN",
            "Did you try to skip by reloading, navigating to your home screen, or closing the tab?<br><br><strong>The Big Math does not forget!</strong> 64TB of virtual arithmetic registers were retrieved from persistent flash cache.<br><br>Calculation has resumed with a <strong>+45s Impatience Tariff</strong>!"
          );
        }, 500);
      }
    } catch (_) {}
  }
}

window.bigMathEngine = new BigMathEngine();
window.addEventListener('DOMContentLoaded', () => {
  window.bigMathEngine.restoreStateFromStorage();
});

// Detect user leaving the tab / minimizing to device home screen!
document.addEventListener('visibilitychange', () => {
  if (!window.bigMathEngine) return;
  if (document.visibilityState === 'hidden') {
    if (window.bigMathEngine.isComputing) {
      window.bigMathEngine.saveStateToStorage();
    }
  } else if (document.visibilityState === 'visible') {
    if (window.bigMathEngine.isComputing) {
      window.bigMathEngine.escapeAttempts = (window.bigMathEngine.escapeAttempts || 0) + 1;
      window.bigMathEngine.totalDurationMs += 35000;
      window.bigMathEngine.setStatusText("🚨 HOME SCREEN / TAB EVASION INTERCEPTED! +35s tariff added!");
      window.bigMathEngine.showEscapeTrap(
        "🚨 HOME SCREEN EVASION INTERCEPTED!",
        "Did you think navigating to your home screen or switching away would let you skip?<br><br>The Silicon ALU intercepted the flight and preserved all 64TB of arithmetic VRAM in NVRAM!<br><br>A <strong>+35s Cowardice Tariff</strong> has been added to your queue."
      );
      window.bigMathEngine.saveStateToStorage();
    }
  }
});
