// The Big Math! - Rage-Bait Cognitive Verification System
// Designed specifically to annoy, baffle, and infuriate the user.
// Features Evil "Lock-In" Illusion of Choice & Captcha of Ego.

class RageQuiz {
  constructor(onCompleteCallback, onPenaltyCallback, customQuestions = null, isBribe = false) {
    this.onComplete = onCompleteCallback;
    this.onPenalty = onPenaltyCallback;
    this.currentQuestionIndex = 0;
    this.container = null;
    this.timerInterval = null;
    this.isBribe = isBribe;
    this.selectedOptionIndex = null;
    this.selectedCaptchaIndices = new Set();

    if (customQuestions && customQuestions.length > 0) {
      this.questions = customQuestions;
    } else {
      this.questions = RageQuiz.getRandomQuestions(8, 12);
    }
  }

  static getRandomQuestions(minCount = 8, maxCount = 12) {
    const bank = window.RAGE_QUESTION_BANK || [];
    if (!bank.length) return [];

    const count = Math.min(
      bank.length,
      Math.floor(Math.random() * (maxCount - minCount + 1)) + minCount
    );

    const shuffled = [...bank].sort(() => 0.5 - Math.random());
    return shuffled.slice(0, count);
  }

  start(targetElement) {
    this.container = targetElement;
    this.currentQuestionIndex = 0;
    this.renderQuestion();
  }

  renderQuestion() {
    if (this.currentQuestionIndex >= this.questions.length) {
      this.finish();
      return;
    }

    const q = this.questions[this.currentQuestionIndex];
    this.selectedOptionIndex = null;
    this.selectedCaptchaIndices.clear();

    if (this.timerInterval) {
      clearInterval(this.timerInterval);
      this.timerInterval = null;
    }

    let optionsHtml = '';

    if (q.type === 'captcha') {
      const tiles = q.tiles || [
        { label: "You attempting mental math", icon: "🧠" },
        { label: "Unjustified confidence", icon: "✨" },
        { label: "Your high school math teacher crying", icon: "😭" },
        { label: "A smug turnip", icon: "🥔" },
        { label: "Belief that 1+2=3", icon: "🤡" },
        { label: "This calculator with 0 errors", icon: "🧮" }
      ];

      optionsHtml = `
        <div class="captcha-container">
          <div class="captcha-subtext">SELECT ALL TILES CONTAINING INTELLECTUAL ARROGANCE:</div>
          <div class="captcha-grid" id="captchaGrid">
            ${tiles.map((tile, idx) => `
              <div class="captcha-tile" data-idx="${idx}">
                <div style="font-size: 1.4rem; margin-bottom: 4px;">${tile.icon || '🔍'}</div>
                <div>${tile.label}</div>
              </div>
            `).join('')}
          </div>
          <button class="quiz-lock-btn" id="lockInBtn" disabled>SELECT AT LEAST 1 TILE TO VERIFY</button>
        </div>
      `;
    } else if (q.type === 'evasive') {
      optionsHtml = `
        <div class="quiz-options-grid evasive-container" id="evasiveContainer" style="position: relative; min-height: 120px;">
          <button class="quiz-btn evasive-btn" id="evasiveBtn">${q.options[0].text}</button>
          <button class="quiz-btn normal-btn" id="submitPotato" data-idx="1">
            <span class="opt-text">${q.options[1].text}</span>
            <span class="opt-indicator">○</span>
          </button>
          <button class="quiz-lock-btn hidden" id="lockInBtn">LOCK IN: "I AM A POTATO" 🔒</button>
        </div>
      `;
    } else if (q.type === 'choice') {
      optionsHtml = `
        <div class="quiz-options-grid">
          ${q.options.map((opt, idx) => `
            <button class="quiz-btn quiz-choice-btn" data-idx="${idx}">
              <span class="opt-text">${opt.text}</span>
              <span class="opt-indicator">○</span>
            </button>
          `).join('')}
          <button class="quiz-lock-btn" id="lockInBtn" disabled>SELECT AN ANSWER TO LOCK IN</button>
        </div>
      `;
    } else if (q.type === 'color_trap') {
      optionsHtml = `
        <div class="quiz-timer-bar">
          <span class="timer-label">TIME REMAINING: <span id="quizCountdown">${q.timer}</span>s</span>
          <div class="timer-track"><div class="timer-fill" id="timerFill"></div></div>
        </div>
        <div class="quiz-options-grid color-grid">
          ${q.options.map((opt, idx) => `
            <button class="quiz-btn color-btn" style="color: ${opt.color}; border-color: ${opt.color};" data-idx="${idx}">
              <span class="opt-text">${opt.label}</span>
              <span class="opt-indicator">○</span>
            </button>
          `).join('')}
          <button class="quiz-lock-btn" id="lockInBtn" disabled>SELECT COLOR TO LOCK IN</button>
        </div>
      `;
    } else if (q.type === 'slider_trap') {
      const target = q.target || 73;
      optionsHtml = `
        <div class="slider-container">
          <div class="slider-val-display">Current: <span id="currentSliderVal">0%</span> (Target: ${target}%)</div>
          <input type="range" min="0" max="100" value="0" class="rage-slider" id="rageSlider">
          <div class="slider-feedback" id="sliderFeedback">Drag to align with cosmological constant...</div>
          <button class="quiz-lock-btn ready" id="lockSliderBtn" style="margin-top: 15px;">LOCK IN SLIDER VALUE 🔒</button>
        </div>
      `;
    }

    const badgeLabel = this.isBribe
      ? `BRIBE AUDIT: TEST ${this.currentQuestionIndex + 1} OF ${this.questions.length}`
      : `SECURITY AUDIT: TEST ${this.currentQuestionIndex + 1} OF ${this.questions.length}`;

    this.container.innerHTML = `
      <div class="quiz-card animate-pop">
        <div class="quiz-header">
          <span class="quiz-step-badge">${badgeLabel}</span>
          <h3 class="quiz-title">${q.title}</h3>
        </div>
        <p class="quiz-question-text">${q.text}</p>
        ${optionsHtml}
        <div class="quiz-response-box hidden" id="quizResponseBox">
          <p id="quizResponseText"></p>
          <button class="quiz-continue-btn" id="quizContinueBtn">ACCEPT VERDICT & NEXT QUESTION ➔</button>
        </div>
      </div>
    `;

    this.attachEvents(q);
  }

  attachEvents(q) {
    const lockInBtn = document.getElementById('lockInBtn');

    if (q.type === 'captcha') {
      const tiles = this.container.querySelectorAll('.captcha-tile');
      tiles.forEach(tile => {
        tile.addEventListener('click', () => {
          if (window.soundEngine) window.soundEngine.playClick();
          const idx = parseInt(tile.getAttribute('data-idx'), 10);
          if (this.selectedCaptchaIndices.has(idx)) {
            this.selectedCaptchaIndices.delete(idx);
            tile.classList.remove('selected');
          } else {
            this.selectedCaptchaIndices.add(idx);
            tile.classList.add('selected');
          }

          if (this.selectedCaptchaIndices.size > 0) {
            lockInBtn.disabled = false;
            lockInBtn.classList.add('ready');
            lockInBtn.textContent = `VERIFY & LOCK IN (${this.selectedCaptchaIndices.size} TILES) 🔒`;
          } else {
            lockInBtn.disabled = true;
            lockInBtn.classList.remove('ready');
            lockInBtn.textContent = 'SELECT AT LEAST 1 TILE TO VERIFY';
          }
        });
      });

      lockInBtn.addEventListener('click', () => {
        lockInBtn.disabled = true;
        lockInBtn.textContent = 'RUNNING NEURAL CAPTCHA AUDIT...';
        if (window.soundEngine) window.soundEngine.playDialup();

        setTimeout(() => {
          lockInBtn.style.display = 'none';
          this.showFeedback(
            `CAPTCHA FAILED: Machine vision algorithm detected latent hubris across selected tiles. Biometric humility rating: 0.00%.`,
            25
          );
        }, 600);
      });

    } else if (q.type === 'evasive') {
      const evasiveBtn = document.getElementById('evasiveBtn');
      const container = document.getElementById('evasiveContainer');
      const potatoBtn = document.getElementById('submitPotato');

      const dodge = (e) => {
        if (window.soundEngine) window.soundEngine.playBeep(600, 0.05);
        const rect = container.getBoundingClientRect();
        const btnW = evasiveBtn.offsetWidth || 140;
        const btnH = evasiveBtn.offsetHeight || 45;
        const maxLeft = Math.max(0, rect.width - btnW - 10);
        const maxTop = Math.max(0, rect.height - btnH - 10);

        const newLeft = Math.floor(Math.random() * maxLeft);
        const newTop = Math.floor(Math.random() * maxTop);

        evasiveBtn.style.position = 'absolute';
        evasiveBtn.style.left = `${newLeft}px`;
        evasiveBtn.style.top = `${newTop}px`;
      };

      evasiveBtn.addEventListener('mouseenter', dodge);
      evasiveBtn.addEventListener('touchstart', (e) => {
        e.preventDefault();
        dodge();
      });
      evasiveBtn.addEventListener('click', (e) => {
        e.preventDefault();
        dodge();
      });

      potatoBtn.addEventListener('click', () => {
        if (window.soundEngine) window.soundEngine.playClick();
        potatoBtn.classList.add('selected');
        potatoBtn.querySelector('.opt-indicator').textContent = '◉';
        lockInBtn.classList.remove('hidden');
        lockInBtn.classList.add('ready');
      });

      lockInBtn.addEventListener('click', () => {
        lockInBtn.disabled = true;
        lockInBtn.textContent = 'LOGGING STARCH CLASSIFICATION...';
        setTimeout(() => {
          lockInBtn.style.display = 'none';
          this.showFeedback(q.options[1].response, q.options[1].penalty);
        }, 500);
      });

    } else if (q.type === 'choice') {
      const buttons = this.container.querySelectorAll('.quiz-choice-btn');

      buttons.forEach(btn => {
        btn.addEventListener('click', () => {
          if (btn.classList.contains('locked-wrong')) return;
          if (window.soundEngine) window.soundEngine.playClick();

          // Reset other buttons
          buttons.forEach(b => {
            b.classList.remove('selected');
            const ind = b.querySelector('.opt-indicator');
            if (ind) ind.textContent = '○';
          });

          // Select this button
          btn.classList.add('selected');
          const ind = btn.querySelector('.opt-indicator');
          if (ind) ind.textContent = '◉';

          this.selectedOptionIndex = parseInt(btn.getAttribute('data-idx'), 10);

          // Enable Lock In button
          lockInBtn.disabled = false;
          lockInBtn.classList.add('ready');
          lockInBtn.textContent = 'LOCK IN FINAL ANSWER 🔒';
        });
      });

      lockInBtn.addEventListener('click', () => {
        if (this.selectedOptionIndex === null) return;
        const opt = q.options[this.selectedOptionIndex];
        const selectedBtn = this.container.querySelector(`.quiz-choice-btn[data-idx="${this.selectedOptionIndex}"]`);

        // Disable all option clicks
        buttons.forEach(b => b.style.pointerEvents = 'none');
        lockInBtn.disabled = true;
        lockInBtn.textContent = 'VERIFYING AGAINST AXIOMS OF ARITHMETIC...';

        if (window.soundEngine) window.soundEngine.playDialup();

        setTimeout(() => {
          lockInBtn.style.display = 'none';

          if (selectedBtn) {
            selectedBtn.classList.remove('selected');
            selectedBtn.classList.add('locked-wrong');
            selectedBtn.innerHTML = `
              <span class="opt-text">${opt.text}</span>
              <span class="locked-badge">✕ INCORRECT</span>
            `;
          }

          // Show specific critique for their chosen answer
          const critique = `<strong>You locked in:</strong> "${opt.text}"<br><br>🚨 <strong>VERDICT: INCORRECT!</strong><br>${opt.response}`;
          this.showFeedback(critique, opt.penalty || 15);
        }, 600);
      });

    } else if (q.type === 'color_trap') {
      let remaining = q.timer;
      const countdownSpan = document.getElementById('quizCountdown');
      const timerFill = document.getElementById('timerFill');
      timerFill.style.transition = `width ${q.timer}s linear`;
      setTimeout(() => { timerFill.style.width = '0%'; }, 50);

      const colorButtons = this.container.querySelectorAll('.color-btn');

      this.timerInterval = setInterval(() => {
        remaining -= 1;
        if (countdownSpan) countdownSpan.textContent = remaining;
        if (remaining <= 0) {
          clearInterval(this.timerInterval);
          lockInBtn.style.display = 'none';
          this.showFeedback("TIME'S UP! Your reaction speed is reminiscent of an acoustic telegraph. +35s penalty.", 35);
        }
      }, 1000);

      colorButtons.forEach(btn => {
        btn.addEventListener('click', () => {
          if (window.soundEngine) window.soundEngine.playClick();
          colorButtons.forEach(b => {
            b.classList.remove('selected');
            const ind = b.querySelector('.opt-indicator');
            if (ind) ind.textContent = '○';
          });
          btn.classList.add('selected');
          const ind = btn.querySelector('.opt-indicator');
          if (ind) ind.textContent = '◉';

          this.selectedOptionIndex = parseInt(btn.getAttribute('data-idx'), 10);
          lockInBtn.disabled = false;
          lockInBtn.classList.add('ready');
          lockInBtn.textContent = 'LOCK IN COLOR SELECTION 🔒';
        });
      });

      lockInBtn.addEventListener('click', () => {
        if (this.timerInterval) clearInterval(this.timerInterval);
        if (this.selectedOptionIndex === null) return;
        const opt = q.options[this.selectedOptionIndex];
        lockInBtn.style.display = 'none';
        this.showFeedback(`Selected "${opt.label}": ${opt.response}`, opt.penalty || 20);
      });

    } else if (q.type === 'slider_trap') {
      const target = q.target || 73;
      const slider = document.getElementById('rageSlider');
      const valDisplay = document.getElementById('currentSliderVal');
      const lockBtn = document.getElementById('lockSliderBtn');
      const feedback = document.getElementById('sliderFeedback');

      slider.addEventListener('input', () => {
        let val = parseInt(slider.value, 10);
        // Cruel: jumps over target
        if (val === target) {
          val = Math.random() > 0.5 ? target - 1 : target + 1;
          slider.value = val;
        }
        valDisplay.textContent = `${val}%`;

        if (Math.abs(val - target) <= 2) {
          feedback.textContent = "SO CLOSE! (Slider quantum jitters active...)";
        } else {
          feedback.textContent = "Nowhere near. Are you even trying?";
        }
      });

      lockBtn.addEventListener('click', () => {
        const val = parseInt(slider.value, 10);
        this.showFeedback(`Locked at ${val}%. Required was ${target}.0000%. Quantum decoherence detected. +25s penalty.`, 25);
      });
    }
  }

  showFeedback(message, penalty = 15) {
    if (window.soundEngine) window.soundEngine.playBuzzer();
    const box = document.getElementById('quizResponseBox');
    const text = document.getElementById('quizResponseText');
    const continueBtn = document.getElementById('quizContinueBtn');

    if (box && text) {
      box.classList.remove('hidden');
      text.innerHTML = `⚠️ <strong>VERIFICATION AUDIT FAILED:</strong><br>${message} <span class="penalty-tag">+${penalty}s Delay</span>`;

      if (this.onPenalty) {
        this.onPenalty(penalty);
      }

      continueBtn.onclick = () => {
        if (window.soundEngine) window.soundEngine.playClick();
        this.currentQuestionIndex++;
        this.renderQuestion();
      };
    }
  }

  finish() {
    if (this.isBribe) {
      this.container.innerHTML = `
        <div class="quiz-card animate-pop quiz-finished-card">
          <div class="quiz-header">
            <span class="quiz-step-badge">BRIBE APPROVED (0% INTEGRITY)</span>
            <h3 class="quiz-title">CORRUPTION CLEARANCE GRANTED!</h3>
          </div>
          <div class="audit-results" style="font-family: var(--font-mono); font-size: 0.85rem; line-height: 1.6; margin: 10px 0;">
            <p>💸 <strong>Bribe Status:</strong> Funds successfully laundered into CPU overclocking bus.</p>
            <p>⚖️ <strong>Ethics Rating:</strong> Completely compromised.</p>
            <p>🚀 <strong>Reward:</strong> 10× TURBO SPEED ACTIVATED!</p>
          </div>
          <button class="quiz-continue-btn primary-btn" id="quizDoneBtn">CLAIM TURBO SPEED ➔</button>
        </div>
      `;
    } else {
      this.container.innerHTML = `
        <div class="quiz-card animate-pop quiz-finished-card">
          <div class="quiz-header">
            <span class="quiz-step-badge">TEST COMPLETED WITH DISTINCTION</span>
            <h3 class="quiz-title">COGNITIVE AUDIT REPORT</h3>
          </div>
          <div class="audit-results" style="font-family: var(--font-mono); font-size: 0.85rem; line-height: 1.6; margin: 10px 0;">
            <p><strong>Status:</strong> Severe Intellectual Malfunction</p>
            <p><strong>Calculated IQ:</strong> ~41.2 (Within margin of error for turnip)</p>
            <p><strong>Verdict:</strong> Allowed to observe calculation under heavy supervision.</p>
          </div>
          <button class="quiz-continue-btn primary-btn" id="quizDoneBtn">RESUME AGONIZING COMPUTE ➔</button>
        </div>
      `;
    }

    document.getElementById('quizDoneBtn').onclick = () => {
      if (window.soundEngine) window.soundEngine.playClick();
      if (this.onComplete) this.onComplete();
    };
  }
}

window.RageQuiz = RageQuiz;
