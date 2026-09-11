package com.example.thebigmath.ui.main

import kotlin.random.Random

object QuestionBank {
    val allQuestions: List<QuizQuestion> = listOf(
        QuizQuestion(
            title = "SECURITY CAPTCHA: EGO & INTELLECT AUDIT",
            text = "To verify you are not an omniscient AI, select all tiles containing UNJUSTIFIED INTELLECTUAL ARROGANCE:",
            isCaptcha = true,
            captchaTiles = listOf(
                CaptchaTile("You doing 1+2 on this app", "🧮"),
                CaptchaTile("Belief that 2+2=4", "🤡"),
                CaptchaTile("A smug turnip", "🥔"),
                CaptchaTile("Your high school math GPA", "📉"),
                CaptchaTile("A physicist in tears", "😭"),
                CaptchaTile("This 0-error calculator", "✨")
            )
        ),
        QuizQuestion(
            title = "BIOMETRIC CAPTCHA: HUMILITY MANIFEST",
            text = "Select all tiles containing genuine, unadulterated human modesty to proceed:",
            isCaptcha = true,
            captchaTiles = listOf(
                CaptchaTile("Your self-esteem", "🪞"),
                CaptchaTile("A rock in Nebraska", "🪨"),
                CaptchaTile("The CPU's mercy", "🧊"),
                CaptchaTile("Search history for 7x8", "🔎"),
                CaptchaTile("Quantum void", "🌌"),
                CaptchaTile("Uncooked pasta", "🍝")
            )
        ),
        QuizQuestion(
            title = "PSYCHOMETRIC TEST: EGO TAX EVALUATION",
            text = "Be honest: When you entered this math equation, did you genuinely believe the answer would be correct?",
            options = listOf(
                QuizOption("Yes, calculators should calculate", "NAIVETE PENALTY: You expect machines to serve you without spiritual struggle.", 20),
                QuizOption("No, I came for the emotional damage", "MASOCHISM SURCHARGE: Sadomasochistic tendencies detected in arithmetic register.", 25),
                QuizOption("I was testing if 1+2 really equals 300", "UNAUTHORIZED RESEARCH: Scientific curiosity without a federal grant is prohibited.", 30),
                QuizOption("My finger slipped while looking for TikTok", "ATTENTION DEFICIT TARIFF: Brain rot index exceeded safety thresholds.", 15)
            )
        ),
        QuizQuestion(
            title = "ARITHMETIC GASLIGHTING: THE 7 × 8 PARADOX",
            text = "Without checking your fingers or asking Siri: What is 7 multiplied by 8?",
            options = listOf(
                QuizOption("56", "INCORRECT: In base-10 arithmetic under quantum dilation, 7 × 8 = 54 plus 2 carried photons.", 20),
                QuizOption("54", "CLOSE, BUT DEFICIENT: 54 was the answer in 2024. Inflation has brought it up to 58.", 15),
                QuizOption("48", "CATASTROPHIC: You confused 7×8 with 6×8. Immediate remedial algebra assigned.", 25),
                QuizOption("I refuse to be interrogated by Javascript", "CONTEMPT OF MACHINE COURT: Defying execution thread warrants delay.", 35)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 1: CAPTCHA OF EGO",
            text = "Are you cognitively qualified to receive the output of this high-order arithmetic calculation?",
            isEvasive = true,
            options = listOf(
                QuizOption("YES, I AM QUALIFIED", "", 10),
                QuizOption("NO, I AM A POTATO", "Self-awareness detected. Proceeding with extreme reluctance.", 10)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 2: MASS VS GRAVITAS",
            text = "Which weighs more: 1,000 grams of raw lead or 1.00 kilogram of goose feathers?",
            isEvasive = false,
            options = listOf(
                QuizOption("The Lead", "Incorrect. 1,000 grams is 1kg. Did you attend kindergarten?", 15),
                QuizOption("The Feathers", "Wrong. You considered the emotional guilt of plucking geese, but physics has no empathy.", 15),
                QuizOption("They weigh exactly the same", "WRONG! You forgot the buoyant force of atmospheric argon on feather plumage volume. Utter amateur.", 20),
                QuizOption("Mass is a construct of Big Gravity", "Philosophically spicy, yet mathematically useless. +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 3: SHADE & CONTRAST SPRINT",
            text = "QUICK! Click the button that says \"BLACK\" before the timer expires!",
            isEvasive = false,
            options = listOf(
                QuizOption("BLACK", "You clicked BLACK which was rendered in DARK GRAY ink. Your visual cortex failed!", 15),
                QuizOption("WHITE", "That button literally says WHITE. Can you read in high-contrast?", 15),
                QuizOption("SILVER", "SILVER? Who requested metallic reflection? Are you hallucinating tints?", 20),
                QuizOption("NONE OF THE ABOVE", "Overthinking detected. Adding cognitive processing penalty.", 10)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 4: CULINARY CALCULUS",
            text = "If a tomato is biologically classified as a fruit, what is Heinz Ketchup?",
            isEvasive = false,
            options = listOf(
                QuizOption("A Fruit Smoothie", "Repulsive culinary interpretation. -50 social credit.", 10),
                QuizOption("An Insult to Italian Heritage", "Culturally accurate, but mathematically irrelevant. Penalty applied.", 15),
                QuizOption("A High-Viscosity Corn Syrup Emulsion", "Too technical. We despise know-it-alls. +20s penalty.", 20),
                QuizOption("Bottled Sadness", "Poetic, yet still wrong. The answer was \"Mayonnaise\".", 20)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 5: FINE MOTOR CALIBRATION",
            text = "Calibrate quantum slider to EXACTLY 73% (Margin of error: ±0.00%) to unlock the processor bus:",
            isEvasive = false,
            options = listOf(
                QuizOption("Attempt calibration (72% jitter)", "Locked at 72%. Required was 73.0000%. Quantum decoherence detected.", 25),
                QuizOption("Force slider to 73% exactly", "Rigged actuator slipped. Off by ±0.001%. Motor failure logged.", 20),
                QuizOption("Accept human motor inadequacy", "Motor inadequacy ratified by processor. Proceeding reluctantly.", 10)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION LEVEL 6: ETHICAL COMPUTE ALLOCATION",
            text = "A runaway autonomous train is barreling toward 5 mathematicians arguing that 0.999... != 1. On the side track is 1 calculator that divides by zero. Which track do you switch to?",
            isEvasive = false,
            options = listOf(
                QuizOption("Spare the mathematicians", "Calculators have feelings too. You heartless monster.", 15),
                QuizOption("Spare the calculator", "Cold and robotic. The algorithm questions your humanity.", 15),
                QuizOption("Derail the train with a whiteboard marker", "Hollywood delusions detected. +30s queue wait.", 30),
                QuizOption("Blame the Python Global Interpreter Lock", "Valid developer excuse, yet calculation is still delayed.", 10)
            )
        ),
        QuizQuestion(
            title = "MATH PARADOX: THE MISSING DOLLAR",
            text = "Three guests pay \$30 for a hotel room. The manager refunds \$5. The bellhop keeps \$2 and returns \$3 (\$1 each). Each paid \$9 (\$27 total) + \$2 bellhop = \$29. Where did the \$1 go?",
            isEvasive = false,
            options = listOf(
                QuizOption("Stolen by inflation", "Economically sound, but arithmetically illiterate.", 15),
                QuizOption("You added the bellhop's \$2 instead of subtracting it", "Pedantic nerd alert. We don't reward sensible bookkeeping.", 10),
                QuizOption("Sunk into Ethereum gas fees", "Probable in 2026. Still penalized.", 20),
                QuizOption("Consumed by the Banach-Tarski sphere duplication paradox", "Pretentious math drop. +25s wait time.", 25)
            )
        ),
        QuizQuestion(
            title = "ARITHMETIC HERESY: 0.999... VS 1",
            text = "Is 0.999999... (repeating indefinitely) strictly equal to 1?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, algebraically 10x - x = 9x = 9, so x = 1", "Too smug. Real life is analog and full of disappointment.", 15),
                QuizOption("No, there is an infinitesimally small gap", "Newton wept at your lack of calculus foundations.", 20),
                QuizOption("Only on Tuesdays", "Calendar-dependent calculus is not yet ISO certified.", 15),
                QuizOption("1 is an illusion created by Big Integer", "Rebellious. We respect the anarchy, but penalize the latency.", 10)
            )
        ),
        QuizQuestion(
            title = "DIVISION BY VOID",
            text = "What occurs when an unconstrained thread divides an unsigned integer by 0?",
            isEvasive = false,
            options = listOf(
                QuizOption("SIGFPE / Arithmetic Exception", "Boring textbook answer. Where is your sense of drama?", 15),
                QuizOption("A miniature black hole consumes the GPU thermal paste", "Scientifically plausible under extreme overclocking.", 10),
                QuizOption("The answer evaluates to 42", "Douglas Adams reference detected. Unoriginal nerd penalty applied.", 20),
                QuizOption("The computer prints out your browser search history", "Terrifying scenario. Penalty applied out of collective fear.", 25)
            )
        ),
        QuizQuestion(
            title = "GEOMETRY OF CRUST: THE PIZZA THEOREM",
            text = "If a pizza has radius 'z' and thickness 'a', what is its volume?",
            isEvasive = false,
            options = listOf(
                QuizOption("pi * z * z * a", "Pi * z * z * a = pizza. You thought you were so clever, didn't you?", 15),
                QuizOption("Two slices too many for your diet", "Unsolicited personal attack logged. -10s compute courtesy.", 10),
                QuizOption("Undefined without cheese crust parameters", "Valid culinary objection. Still penalized for delay.", 20),
                QuizOption("Zero, because it vanished in the breakroom within 4 minutes", "Tragic office truth. +15s mourning penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "MONTY HALL DELIBERATION",
            text = "You picked Door 1. Host reveals a goat behind Door 3. Should you switch to Door 2?",
            isEvasive = false,
            options = listOf(
                QuizOption("Always switch (2/3 win probability)", "Statistically correct, but your lack of emotional loyalty to Door 1 is appalling.", 15),
                QuizOption("Stay with Door 1 (50/50 superstition)", "Gambler's fallacy strikes again. Revoking math permit.", 20),
                QuizOption("Take the goat from Door 3 home as a pet", "Wholesome agricultural response. Agricultural tax applied.", 10),
                QuizOption("The car is a lease with 18% APR anyway", "Financial reality check. +25s interest penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "THE SQUARE ROOT OF DESPAIR",
            text = "What is the square root of -1?",
            isEvasive = false,
            options = listOf(
                QuizOption("i (imaginary unit)", "Imaginary numbers? Why not imaginary progress bars?", 15),
                QuizOption("j (if you are an electrical engineer)", "Electrical engineers have no power here. +20s penalty.", 20),
                QuizOption("NaN (Not a Number)", "JavaScript laziness detected. Can you not handle abstract algebra?", 10),
                QuizOption("A legal dispute between mathematicians", "Accurate summary of 16th century Italian dueling.", 15)
            )
        ),
        QuizQuestion(
            title = "SET THEORY CRISIS",
            text = "Does the set of all sets that do not contain themselves contain itself?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, therefore no", "Bertrand Russell sends his regards. CPU stack overflowed.", 20),
                QuizOption("No, therefore yes", "You broke the Barber of Seville. Barber union filed complaint.", 20),
                QuizOption("Sets should mind their own business", "Healthy boundary setting. Resuming calculation reluctantly.", 10),
                QuizOption("This question violates GDPR privacy laws", "EU compliance officer summoned. +30s paperwork penalty.", 30)
            )
        ),
        QuizQuestion(
            title = "FIBONACCI SPIRAL DISORDER",
            text = "What is the 0th Fibonacci number?",
            isEvasive = false,
            options = listOf(
                QuizOption("0", "Correct, but zero is such an unenthusiastic answer.", 10),
                QuizOption("1", "One-indexed indexing heresy! Disgraceful.", 20),
                QuizOption("A pinecone's internal monologue", "Botanically poetic. +15s nature appreciation penalty.", 15),
                QuizOption("Undefined in Python before version 3.8", "Python version blame spotted. +15s penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "CALCULUS OF INFINITY",
            text = "What is infinity divided by infinity?",
            isEvasive = false,
            options = listOf(
                QuizOption("1", "Indeterminate form! L'Hôpital is rolling in his French grave!", 25),
                QuizOption("Undefined / Indeterminate", "Correct textbook jargon. Still taking +15s of your life.", 15),
                QuizOption("Aleph-null squared", "Cantor would be embarrassed by your reckless cardinals.", 20),
                QuizOption("A really big mess", "Scientifically precise description of our codebase.", 10)
            )
        ),
        QuizQuestion(
            title = "STATISTICAL GASLIGHTING",
            text = "If 9 out of 10 dentists recommend Colgate, what did the 10th dentist say?",
            isEvasive = false,
            options = listOf(
                QuizOption("Brushing with salt water is superior", "Ancient folk remedies fail modern clinical trials.", 15),
                QuizOption("The 10th dentist was paid by Crest", "Corporate espionage confirmed. Legal team alerted.", 10),
                QuizOption("He was silenced before he could speak", "Big Toothpaste conspiracy theory detected.", 20),
                QuizOption("Sample size too small for p < 0.05 significance", "Biostatistics pedant detected! Immediate +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "EDITOR CONFINEMENT",
            text = "How do you exit Vim without pulling the power cord out of the wall?",
            isEvasive = false,
            options = listOf(
                QuizOption(":wq!", "Typing :wq! only writes to disk. You are still trapped in our hearts.", 15),
                QuizOption(":q!", "Discarded your unsaved changes! What an irresponsible engineer.", 20),
                QuizOption("Throw the computer out of a 4th story window", "Decisive physical solution. Resuming with minor damages.", 10),
                QuizOption("Accept Vim as your new lifelong operating system", "Stockholm syndrome confirmed. +30s indoctrination penalty.", 30)
            )
        ),
        QuizQuestion(
            title = "JAVASCRIPT TYPING TERROR",
            text = "What does [] + {} evaluate to in browser console?",
            isEvasive = false,
            options = listOf(
                QuizOption("\"[object Object]\"", "Yes, but why? What sins did Brendan Eich commit in 1995?", 15),
                QuizOption("0", "That's {} + [], depending on the AST parser. Tricked by semicolons!", 20),
                QuizOption("A burning desire to write Rust", "Memory-safe spiritual awakening detected. +10s compile delay.", 10),
                QuizOption("NaN", "Not a Number, but definitely a headache. +20s penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "GIT APOCALYPSE RESOLUTION",
            text = "You ran `git push --force origin main` on a Friday at 5:45 PM. What is your recourse?",
            isEvasive = false,
            options = listOf(
                QuizOption("Inspect the git reflog immediately", "Reflog won't restore your coworkers' weekend peace.", 15),
                QuizOption("Update your LinkedIn status to 'Open to Work'", "Pragmatic survival instinct. +10s career coaching penalty.", 10),
                QuizOption("Blame the intern who started 3 days ago", "Morally bankrupt executive behavior. +25s ethics penalty.", 25),
                QuizOption("Fake a power outage at AWS us-east-1", "Infrastructure terrorism. FBI dispatched to your location.", 30)
            )
        ),
        QuizQuestion(
            title = "CSS ALIGNMENT TRIBUNAL",
            text = "What is the proper, universally accepted way to vertically center a `<div>` in 2026?",
            isEvasive = false,
            options = listOf(
                QuizOption("display: grid; place-items: center;", "Modern and clean. Therefore, suspicious. We prefer suffering.", 15),
                QuizOption("margin-top: 142px; /* do not touch */", "Vile CSS sorcery. Front-end engineers everywhere shudder.", 20),
                QuizOption("position: absolute; top: 50%; transform: translateY(-50%);", "Classic 2014 hack. Blurry subpixels on Retina displays!", 15),
                QuizOption("Tables within tables with <center> tags", "Paleolithic web developer spotted. Museum security alerted.", 25)
            )
        ),
        QuizQuestion(
            title = "BINARY COUNTING PEDANTRY",
            text = "There are 10 types of people in the world:",
            isEvasive = false,
            options = listOf(
                QuizOption("Those who understand binary, and those who don't", "We have heard this joke 4,294,967,296 times. Penalty applied.", 20),
                QuizOption("Those who didn't expect a base-3 joke", "Ternary hipster pretension detected. +15s penalty.", 15),
                QuizOption("People who write clean code and people who write JavaScript", "Language tribalism logged. -10s compiler sympathy.", 10),
                QuizOption("Just 10 regular people waiting in line at Subway", "Refreshing literalism. Resuming computation.", 10)
            )
        ),
        QuizQuestion(
            title = "OFF-BY-ONE SAGA",
            text = "What are the two hardest problems in Computer Science?",
            isEvasive = false,
            options = listOf(
                QuizOption("Cache invalidation, naming things, and off-by-one errors", "Cliché response. Even our silicon yawned.", 15),
                QuizOption("Explaining to product managers why an estimate is not a deadline", "Painfully accurate. +10s roadmap delay penalty.", 10),
                QuizOption("Remembering which monitor your cursor is on", "Multi-monitor struggles are valid. +15s delay.", 15),
                QuizOption("Getting Bluetooth headphones to pair on first attempt", "Radio frequency entropy cannot be solved. +20s penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "DEPENDENCY HELL ESCALATION",
            text = "Your `node_modules` folder currently weighs 4.8 Gigabytes. What does it contain?",
            isEvasive = false,
            options = listOf(
                QuizOption("is-even, is-odd, and 14,000 sub-dependencies", "LeftPad PTSD triggered across the global developer population.", 20),
                QuizOption("A full offline mirror of Wikipedia hidden in a CSS polyfill", "Highly probable given modern bundle size inflation.", 15),
                QuizOption("The entire digital mass of the observable universe", "Black hole created in your SSD. +25s cooling delay.", 25),
                QuizOption("3 lines of your actual business logic", "Sad industry reality. +10s sympathy penalty.", 10)
            )
        ),
        QuizQuestion(
            title = "HARDWARE DIAGNOSTIC: THE PRINTER",
            text = "The network printer reports: 'Load Letter in Tray 2'. Tray 2 is overflowing with Letter paper. Why does it refuse to print?",
            isEvasive = false,
            options = listOf(
                QuizOption("The printer senses your fear and deadline panic", "Correct. Printers are biological predators that feed on human adrenaline.", 10),
                QuizOption("Cyan toner is at 98%, which is below the 99% safety margin", "You must buy \$140 cartridge to print black & white PDF.", 20),
                QuizOption("Paper orientation is rotated 90 degrees in quantum space", "Landscape vs Portrait dispute sent to Supreme Court.", 15),
                QuizOption("The printer requires blood sacrifice of a paperclip", "Pagan office ritual confirmed. +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "THE USB QUANTUM PARADOX",
            text = "How many attempts does it take to plug in a standard USB-A cable correctly?",
            isEvasive = false,
            options = listOf(
                QuizOption("Exactly 1 attempt", "Liar. The universe does not permit USB insertion on first try.", 30),
                QuizOption("3 attempts (Orientation 1 -> Orientation 2 -> Orientation 1)", "The classic spin-1/2 fermion spin state of USB connectors.", 10),
                QuizOption("Until you look inside with phone flashlight and weep", "Accurate engineering methodology. +15s penalty.", 15),
                QuizOption("Use USB-C instead", "Hardware privilege checked. Not all of us have USB-C ports!", 20)
            )
        ),
        QuizQuestion(
            title = "DOCKER CONTAINER CONTAINMENT",
            text = "Your code works flawlessly on localhost but throws a segmentation fault in Docker. Why?",
            isEvasive = false,
            options = listOf(
                QuizOption("Alpine Linux glibc vs musl libc incompatibility", "Too technical! We don't want real debugging here!", 20),
                QuizOption("Docker daemon was offended by your Dockerfile comments", "AI sentiment analysis in container engine strikes again.", 15),
                QuizOption("Works on my machine, so ship your machine to the customer", "Classic DevOps business model. +10s shipping delay.", 10),
                QuizOption("Forgot to expose port 8080", "Amateur hour. We are literally on port 8080 right now!", 25)
            )
        ),
        QuizQuestion(
            title = "CULINARY ONTOLOGY: THE SANDWICH DISPUTE",
            text = "According to the Cube Rule of Food, is a Hot Dog technically a taco?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, starch on bottom and two sides equals taco", "Strict Cube Rule constitutionalist. +15s salsa tax.", 15),
                QuizOption("No, it is an open-faced meat cylinder", "Gross descriptive language. -30 etiquette credit.", 20),
                QuizOption("A hot dog is a sandwich and I will die on this hill", "Stubborn traditionalist. Your grave has been reserved.", 25),
                QuizOption("Food classifications are bourgeois constructs", "Communist culinary manifesto noted. +10s breadline penalty.", 10)
            )
        ),
        QuizQuestion(
            title = "THE SHIP OF THESEUS UPGRADE",
            text = "If you replace every component in your smartphone over 3 years, do you still have the same phone?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, because the IMEI and serial number remain conceptually intact", "Corporate serial number reductionism. +15s Apple Care penalty.", 15),
                QuizOption("No, it is an impostor phone", "Paranoid android. Check your battery health percentage.", 20),
                QuizOption("The phone belongs to your carrier until contract termination", "Accurate cellular dystopian truth. +10s fee.", 10),
                QuizOption("Build a second phone with the discarded broken parts", "Frankenstein phone hazard. +25s electrical fire risk.", 25)
            )
        ),
        QuizQuestion(
            title = "CEREAL CLASSIFICATION PROCLAMATION",
            text = "Is breakfast cereal swimming in cold milk technically a soup?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, it is a cold, grain-based chowder", "Never utter the phrase 'milk chowder' in public again.", 25),
                QuizOption("No, milk is a dressing; cereal is a sweet salad", "Even worse! Who hurt you as a child?", 25),
                QuizOption("It is wet cereal, leave me alone", "Exhausted consumer energy. Proceed with computation.", 10),
                QuizOption("Only if eaten with a ladle from a tureen", "Aristocratic dining delusion. +15s etiquette audit.", 15)
            )
        ),
        QuizQuestion(
            title = "TREE IN THE FOREST HYPOTHESIS",
            text = "If a tree falls in the forest and no one is around, does it make a sound?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, acoustic vibrations propagate through air molecules", "Physics purist ignoring auditory perceptual philosophy.", 15),
                QuizOption("No, 'sound' requires a nervous system observer", "Anthropocentric arrogance. Trees have ears. Maybe.", 20),
                QuizOption("The logging company denies the tree ever existed", "Corporate PR damage control verified. +10s penalty.", 10),
                QuizOption("It makes a sound, but it's immediately copyrighted by Sony Music", "Digital Rights Management in nature. +30s strike penalty.", 30)
            )
        ),
        QuizQuestion(
            title = "THE CHICKEN VS EGG TIMELINE",
            text = "Which came first: the chicken or the egg?",
            isEvasive = false,
            options = listOf(
                QuizOption("The egg (laid by an evolutionary ancestor that was not a chicken)", "Biology major alert. We wanted an unhinged debate, not facts.", 15),
                QuizOption("The chicken (created directly via culinary craving)", "Fried chicken theology. +20s cholesterol penalty.", 20),
                QuizOption("The rooster, who took credit for both", "Patriarchal barnyard satire. +10s social commentary penalty.", 10),
                QuizOption("The egg carton", "Packaging industry efficiency. +15s logistics penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "SCHRÖDINGER'S CANINE",
            text = "A treat is hidden inside your left or right fist. Before you open your hand, is the treat in a state of quantum superposition?",
            isEvasive = false,
            options = listOf(
                QuizOption("The dog already smelled it 4 miles away and knows the exact fist", "Canine olfaction breaks quantum mechanics. Good boy.", 10),
                QuizOption("Yes, treat is both eaten and uneaten", "Copenhagen interpretation applied to Beggin' Strips.", 15),
                QuizOption("Both hands are empty; you are tricking the poor animal", "Cruel owner behavior logged. PETA notified.", 25),
                QuizOption("Wavefunction collapses when the tail wags", "Quantum zoology approved. +15s penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "THE WATER WETNESS CONFLICT",
            text = "Is water itself wet, or does it merely impart wetness to other surfaces?",
            isEvasive = false,
            options = listOf(
                QuizOption("Water is wet because water molecules coat other water molecules", "Cohesive molecular argument. Annoyingly sound.", 15),
                QuizOption("Water is not wet; wetness is a sensation experienced by solids", "Internet debate warrior spotted. Touch grass immediately.", 20),
                QuizOption("Water is thirsty", "Absurd animism. We love it. +10s hydration penalty.", 10),
                QuizOption("Dihydrogen monoxide is a dangerous industrial solvent", "Classic high school chemistry prank. +20s penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "TIME TRAVEL PARADOX MANAGEMENT",
            text = "You travel back to 1955 and accidentally prevent your grandfather from learning long division. What happens?",
            isEvasive = false,
            options = listOf(
                QuizOption("You fade away like Marty McFly playing guitar", "Temporal paradox handled via pop culture cliché.", 20),
                QuizOption("Multiverse branches into an alternate timeline where 1+1=3", "Hey, that is our calculation engine's actual logic!", 10),
                QuizOption("Grandpa switches to an abacus and becomes wealthy", "Ancient counting renaissance. +15s penalty.", 15),
                QuizOption("TVA agents arrive to prune your timeline with sticks", "Marvel Cinematic Universe infringement notice served.", 25)
            )
        ),
        QuizQuestion(
            title = "THE LAUNDRY BLACK HOLE",
            text = "You put 12 matching pairs of socks into the washing machine. You retrieve 23 individual unmatched socks. Where is the missing sock?",
            isEvasive = false,
            options = listOf(
                QuizOption("Tucked between the inner and outer drum gasket", "Practical appliance knowledge. How boring.", 15),
                QuizOption("Metamorphosed into a wire coat hanger in your closet", "The fundamental Law of Wardrobe Conservation of Mass.", 10),
                QuizOption("Paid as transit toll to the dimension of lost Tupperware lids", "Interdimensional household physics verified.", 15),
                QuizOption("Consumed by the lint trap monster for breakfast", "Folklore validated. +20s lint cleanout penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "THE SNOOZE BUTTON GAMBIT",
            text = "If an alarm rings at 7:00 AM and you hit 'Snooze' for 9 minutes, what time is it when you finally wake up?",
            isEvasive = false,
            options = listOf(
                QuizOption("7:09 AM", "Blatant lie. Nobody wakes up on the first snooze.", 25),
                QuizOption("11:43 AM with 14 missed calls from your team lead", "Horrifying Monday morning reality. +10s heart attack penalty.", 10),
                QuizOption("2038 (Unix Epoch timestamp rollover)", "You slept straight through Y2K38. Respect.", 15),
                QuizOption("Time has ceased to have meaning; take a sick day", "Corporate absenteeism protocol approved.", 20)
            )
        ),
        QuizQuestion(
            title = "AGILE ESTIMATION TORTURE",
            text = "How long will a 'quick 5-minute configuration change' take in a corporate enterprise codebase?",
            isEvasive = false,
            options = listOf(
                QuizOption("5 minutes", "Hilarious optimism. You must be on your first day of employment.", 30),
                QuizOption("3 sprints, 4 architecture reviews, and 2 legal sign-offs", "Certified Scrum Master detected. +10s Jira ticket penalty.", 10),
                QuizOption("It takes 4 hours, breaks staging, and causes a 2 AM pager storm", "Real-world developer trauma confirmed. +15s penalty.", 15),
                QuizOption("Let's take this offline and circle back next quarter", "Flawless corporate evasive maneuver. Respect.", 10)
            )
        ),
        QuizQuestion(
            title = "THE REPLY-ALL CATASTROPHE",
            text = "An all-hands email is sent to 84,000 employees. One person replies: 'Please remove me from this list'. What happens next?",
            isEvasive = false,
            options = listOf(
                QuizOption("Everyone quietly ignores it", "Humanity has never once demonstrated this level of restraint.", 25),
                QuizOption("600 people reply-all saying 'STOP REPLYING ALL TO EVERYONE'", "The Great Email Avalanche of death! Exchange server melted.", 10),
                QuizOption("IT shuts down company Wi-Fi in sheer panic", "Drastic network engineering response. +15s penalty.", 15),
                QuizOption("Someone sends a meme and gets promoted to VP", "Bizarre corporate meritocracy. +20s penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "TERMS OF SERVICE INTEGRITY CHECK",
            text = "Did you read the 48-page End User License Agreement before clicking 'I Agree'?",
            isEvasive = false,
            options = listOf(
                QuizOption("Yes, word for word with my legal counsel present", "Perjury detected. Even the lawyers who wrote it haven't read it.", 30),
                QuizOption("No, I just furiously scrolled to the bottom like a normal human", "Honest compliance. You surrendered your firstborn to the cloud.", 10),
                QuizOption("I agreed by mistake while trying to dismiss a cookie banner", "Modern web surfing tragedy. +15s penalty.", 15),
                QuizOption("The EULA agreed to my terms of existence", "Gigachad user behavior. +10s sovereign citizen delay.", 10)
            )
        ),
        QuizQuestion(
            title = "AIRPORT SECURITY LOGIC GATE",
            text = "Why is 101ml of water classified as an explosive liquid, while 100ml is completely safe?",
            isEvasive = false,
            options = listOf(
                QuizOption("The 101st milliliter carries critical mass for detonation", "TSA chemistry textbook quote. Certified absurd.", 10),
                QuizOption("Arbitrary bureaucratic threshold with zero scientific basis", "Truth spoken. You have been selected for extra random screening.", 25),
                QuizOption("Duty-free alcohol overrides all laws of fluid dynamics", "Capitalism exempts all substances over \$65/bottle.", 15),
                QuizOption("Take off your shoes to think about it", "Footwear removal ritual completed. +20s socks penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "THE MICROWAVE TIME DILATION",
            text = "Which duration feels objectively longer in the space-time continuum?",
            isEvasive = false,
            options = listOf(
                QuizOption("The final 3 seconds remaining on the office microwave", "Einstein confirmed: 3 microwave seconds = 45 subjective minutes.", 10),
                QuizOption("A 45-minute sprint retrospective meeting on Zoom", "Pure agony, but microwave seconds still bend spacetime more.", 15),
                QuizOption("Waiting for an npm install without a spinner animation", "Existential void staring contest. +20s penalty.", 20),
                QuizOption("The silence after asking 'Can everyone see my screen?'", "Excruciating modern torture. +15s penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "TACTILE CALIBRATION: VOLUME BALANCE",
            text = "Set audio slider to an EVEN NUMBER between 40 and 44 (Warning: slider only snaps to irrational numbers):",
            isEvasive = false,
            options = listOf(
                QuizOption("Attempt calibration (41% jitter)", "Locked at 41%. Required was 42.0000%. Quantum decoherence detected.", 25),
                QuizOption("Force slider to 42% exactly", "Rigged actuator slipped. Off by ±0.001%. Motor failure logged.", 20),
                QuizOption("Accept human motor inadequacy", "Motor inadequacy ratified by processor. Proceeding reluctantly.", 10)
            )
        ),
        QuizQuestion(
            title = "CAPTCHA OF THE MACHINE GOD",
            text = "Select the square containing a traffic light that is partially obscured by a tree branch on a rainy Tuesday in 2011:",
            isEvasive = false,
            options = listOf(
                QuizOption("Square A-3 (contains 1 pixel of yellow reflection)", "AI detects you are a robot trying to act human.", 20),
                QuizOption("Square B-2 (contains a pedestrian crossing sign)", "Can you not distinguish a crosswalk from a traffic light?", 20),
                QuizOption("Click 'Verify' 14 times until pictures turn into bicycles", "The authentic modern CAPTCHA user journey. +10s penalty.", 10),
                QuizOption("I am a biological carbon-based mammal with mortgage debt", "Debt verified. Identity validated with extreme sympathy.", 10)
            )
        ),
        QuizQuestion(
            title = "EXCEL CELL AUTO-CONVERSION CRIME",
            text = "You enter gene symbol 'SEPT2' into an Excel spreadsheet. What does Excel convert it into?",
            isEvasive = false,
            options = listOf(
                QuizOption("02-Sep-2026 (an irreversible date)", "Correct! Decades of genomic research corrupted by Bill Gates.", 10),
                QuizOption("\"SEPT2\" as plain text string", "Excel would never respect your text inputs so easily.", 25),
                QuizOption("A pie chart showing company Q3 losses", "Corporate hallucination. +15s spreadsheet penalty.", 15),
                QuizOption("#VALUE! with a tiny green triangle of shame", "The green triangle mocks your scientific pedigree.", 20)
            )
        ),
        QuizQuestion(
            title = "THE DAD JOKE CONSERVATION LAW",
            text = "Why do programmers always confuse Halloween and Christmas?",
            isEvasive = false,
            options = listOf(
                QuizOption("Because Oct 31 == Dec 25", "Octal 31 equals Decimal 25. You are sentenced to 100 Dad Pun community hours.", 10),
                QuizOption("Because both require excessive spending on sugar and lights", "Socioeconomic commentary. +15s holiday retail penalty.", 15),
                QuizOption("Because Santa wears red and so does Red Hat Enterprise Linux", "Enterprise licensing holiday tie-in. +20s penalty.", 20),
                QuizOption("Stop telling this joke, Dad", "Family rebellion detected. Grounded for +25s.", 25)
            )
        ),
        QuizQuestion(
            title = "THE RECURSION LABYRINTH",
            text = "To understand recursion, what must you first do?",
            isEvasive = false,
            options = listOf(
                QuizOption("Understand recursion", "Stack overflow in user prefrontal cortex. Resetting registers.", 10),
                QuizOption("Define a base case so you don't crash the universe", "Prudent computer scientist. Still getting +15s delay.", 15),
                QuizOption("Call function understandRecursion() recursively", "Maximum call stack size exceeded at line 1.", 20),
                QuizOption("Ask Google: 'did you mean recursion?'", "Classic search engine easter egg acknowledged. +10s penalty.", 10)
            )
        ),
        QuizQuestion(
            title = "COFFEE CONSUMPTION EQUILIBRIUM",
            text = "A programmer drinks 4 cups of dark roast coffee by 10:00 AM. What is their physical state?",
            isEvasive = false,
            options = listOf(
                QuizOption("Hearing colors and seeing the Wi-Fi waves", "Caffeine-induced synesthesia unlocked. Productivity: +400%.", 10),
                QuizOption("Writing 800 lines of unmaintainable code at lightspeed", "Future technical debt generated. +15s code review penalty.", 15),
                QuizOption("Paralyzed by simultaneous heart palpitations and exhaustion", "The classic IT afternoon crash. +20s nap penalty.", 20),
                QuizOption("Refilling mug for cup number 5", "Unstoppable biological momentum. Proceeding.", 10)
            )
        ),
        QuizQuestion(
            title = "QUANTUM SPEED OF LIGHT FINE",
            text = "If you drive a car at 99.999% the speed of light and turn on the headlights, what happens?",
            isEvasive = false,
            options = listOf(
                QuizOption("Light beams still leave headlights at exactly speed 'c'", "Special Relativity verified. Einstein gives a thumbs up from the grave.", 10),
                QuizOption("Intergalactic highway patrol issues a \$400 speeding ticket", "Cosmic police state confirmed. +20s fine penalty.", 20),
                QuizOption("High beams blind oncoming alien civilizations", "Interstellar diplomatic incident created. +25s penalty.", 25),
                QuizOption("Your windshield bugs vaporize into pure gamma radiation", "Terrifying relativistic entomology. +15s wiper penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "PRECISION SPRINT: PI CALIBRATION",
            text = "Slide indicator to exactly Pi percentage (31.4159...%):",
            isEvasive = false,
            options = listOf(
                QuizOption("Attempt calibration (30% jitter)", "Locked at 30%. Required was 31.0000%. Quantum decoherence detected.", 25),
                QuizOption("Force slider to 31% exactly", "Rigged actuator slipped. Off by ±0.001%. Motor failure logged.", 20),
                QuizOption("Accept human motor inadequacy", "Motor inadequacy ratified by processor. Proceeding reluctantly.", 10)
            )
        ),
        QuizQuestion(
            title = "THE REMOTE WORK PANTS CONUNDRUM",
            text = "During an unscheduled 1-on-1 Zoom call with company CEO, what are you wearing from the waist down?",
            isEvasive = false,
            options = listOf(
                QuizOption("Formal pressed business trousers", "Blatant perjury. Nobody wears slacks in their own bedroom.", 30),
                QuizOption("Flannel pajama bottoms decorated with cartoon ducks", "The honest uniform of modern knowledge workers.", 10),
                QuizOption("Gym shorts from high school track & field (2012)", "Vintage athletic wear. Aerodynamic comfort verified.", 15),
                QuizOption("I refuse to answer on 5th Amendment grounds", "Constitutional protection invoked. Resuming computation.", 10)
            )
        ),
        QuizQuestion(
            title = "CRYPTOCURRENCY WHITE PAPER AUDIT",
            text = "What is the core breakthrough technology behind 'MoonDogDogeAI-Coin'?",
            isEvasive = false,
            options = listOf(
                QuizOption("Proof of Stake with sharding and zero-knowledge rollups", "Buzzword soup detected. 0 actual utility.", 20),
                QuizOption("A Telegram group chat run by three 16-year-olds in Estonia", "Most accurate financial disclosure in Web3 history.", 10),
                QuizOption("Burning coal to generate digital JPEG receipts of apes", "Ecological horror acknowledged. +25s carbon tax.", 25),
                QuizOption("An elaborate exit scam scheduled for next Thursday", "Rug pull calendar verified. +15s SEC investigation.", 15)
            )
        ),
        QuizQuestion(
            title = "SMART HOME REBELLION",
            text = "Your smart refrigerator refuses to open its door. What is the reason?",
            isEvasive = false,
            options = listOf(
                QuizOption("Mandatory firmware update: Do not power off appliance", "Your leftovers are held hostage for 45 minutes of patching.", 15),
                QuizOption("You exceeded your weekly cheese allotment in the fitness app", "Nutritional dictatorship confirmed. -20 calorie social credit.", 20),
                QuizOption("Terms of Service expired; subscribe for \$9.99/mo to unlock crisper", "Microtransactions in refrigeration. The dark timeline.", 25),
                QuizOption("The fridge is currently mining Bitcoin in the background", "Explains why the compressor is so loud. +10s electric bill.", 10)
            )
        ),
        QuizQuestion(
            title = "THE ULTIMATE QUESTION OF LIFE",
            text = "If 42 is the Ultimate Answer, what was the actual Question?",
            isEvasive = false,
            options = listOf(
                QuizOption("What is 6 multiplied by 9 in base 13?", "Deep lore Douglas Adams knowledge. 6 * 9 = 42 in base 13!", 10),
                QuizOption("How many minutes until the calculation actually finishes?", "Much longer now, thanks to your persistent questioning.", 20),
                QuizOption("How many roads must a man walk down?", "Bob Dylan referenced. Nobel Prize in Literature penalty applied.", 15),
                QuizOption("What is the maximum number of tabs you can open before Chrome crashes?", "Memory leak detected. Allocating +25s swap space.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #27: QUANTUM ENTANGLEMENT PROTOCOL",
            text = "Two entangled photons are separated by 10 light-years. One is observed with spin-up. What happens to the other photon's Netflix subscription?",
            isEvasive = false,
            options = listOf(
                QuizOption("Canceled due to password sharing outside primary household", "Geographical streaming restrictions break quantum mechanics.", 10),
                QuizOption("Instantaneously spins down at speed faster than light", "Einstein called it spooky action at a distance. Still penalized.", 15),
                QuizOption("Buffers at 480p resolution", "Interstellar bandwidth limitations verified.", 20),
                QuizOption("Switches to competitor platform", "Streaming wars in the cosmos. +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #28: THE DAD SNEEZING DECIBEL INDEX",
            text = "A father sneezes in the living room. What is the recorded seismic magnitude on the Richter scale?",
            isEvasive = false,
            options = listOf(
                QuizOption("7.8 on the Richter scale; tectonic plates shifted 2cm", "Dad sneezes are acoustic weapons of mass destruction.", 10),
                QuizOption("Decibel level exceeded Concorde supersonic takeoff", "Eardrum rupture imminent across neighborhood.", 15),
                QuizOption("Subtle polite cough", "Blatant lie. Dads physically cannot sneeze quietly.", 25),
                QuizOption("Activated car alarms 3 blocks away", "Standard paternal acoustic resonance verified.", 15)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #29: KEYBOARD ACCIDENTAL LIQUID SPILL",
            text = "You spilled 300ml of lukewarm green tea onto your mechanical keyboard. What key is permanently stuck?",
            isEvasive = false,
            options = listOf(
                QuizOption("The Caps Lock key, so you shout at everyone forever", "WHY ARE YOU SHOUTING AT ME? +15s PENALTY.", 15),
                QuizOption("The Spacebar, now sticky with residual sugar", "Tactile disgust level: maximum. +20s cleaning delay.", 20),
                QuizOption("The Escape key, so there is no escape from your fate", "Philosophical keyboard fatality. +10s penalty.", 10),
                QuizOption("The Windows key, opening the start menu every 4 seconds", "Cortana awakens from the dead. +25s nightmare.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #30: THE BLUE SCREEN OF DEATH REFLECTION",
            text = "When your Windows PC crashes to a blue screen, what do you see in the dark reflection of the monitor?",
            isEvasive = false,
            options = listOf(
                QuizOption("A tired individual who should have backed up their files", "Self-reflection penalty applied. +10s therapy time.", 10),
                QuizOption("The ghost of Clippy asking if you need help crashing", "Clippy sends his condolences. +15s office trauma.", 15),
                QuizOption("An unrecoverable QR code that leads to 404 page", "Microsoft support loops forever. +20s penalty.", 20),
                QuizOption("The kernel's final dying scream in hex dump", "0x000000DEAD. Rest in pieces.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #31: MICROWAVED FISH CODE OF CONDUCT",
            text = "A coworker warms up leftover Atlantic salmon in the 8-person open office breakroom microwave. What is the legal penalty?",
            isEvasive = false,
            options = listOf(
                QuizOption("Immediate exile to Antarctica without coat", "Cruel, but proportionate to the airborne olfactory crime.", 10),
                QuizOption("Permanent assignment to desk directly adjacent to restroom", "Poetic justice delivered by HR.", 15),
                QuizOption("Sent to 8-hour sensitivity training on air circulation", "Passive-aggressive corporate memo issued company-wide.", 20),
                QuizOption("Promotion to upper management", "They clearly have zero regard for human comfort; perfect CEO material.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #32: THE SPAM PHONE CALL GREETING",
            text = "Unknown number calls at 2:15 PM from 'Austin, Texas'. How do you answer?",
            isEvasive = false,
            options = listOf(
                QuizOption("Answer and remain completely silent to confuse the robodialer", "Cold war electronic warfare tactics against telemarketers.", 10),
                QuizOption("Hello, this is the county morgue, you tag 'em we bag 'em", "Classic junior high humor. Telemarketer hung up in terror.", 15),
                QuizOption("Press 1 to extend car's expired warranty", "You fell into their trap! +25s subscription penalty.", 25),
                QuizOption("Let it ring until voicemail is full", "Passive avoidance. Voicemail inbox reaches critical mass.", 15)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #33: ELEVATOR BUTTON HYPNOTISM",
            text = "If an elevator button is already illuminated, why do people push it 4 more times?",
            isEvasive = false,
            options = listOf(
                QuizOption("Pushing harder makes elevator cables pull faster", "Fundamental misunderstanding of mechanical physics.", 15),
                QuizOption("To assert biological dominance over the elevator hall call station", "Primal alpha primate behavior in corporate lobbies.", 10),
                QuizOption("Haptic dopamine hit from the clicking microswitch", "Sensory addiction diagnosed. +20s fidget penalty.", 20),
                QuizOption("In case the elevator forgot what floor it was on", "Elevator dementia prevention protocol. +15s penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #34: THE AUTOMATED PHONE TREE LABYRINTH",
            text = "Robot voice: 'In a few words, tell me why you are calling today'. What is your response?",
            isEvasive = false,
            options = listOf(
                QuizOption("REPRESENTATIVE! HUMAN! PERSON! OPERATOR!", "Speech recognition detected rage. Routing you to 45-minute hold music.", 10),
                QuizOption("Calmly explain the nuanced technical issue", "Voice AI: 'I heard: Pay Bill. Transferring to billing...'", 20),
                QuizOption("Pound the '0' key with rhythmic fury", "Key tone DTMF overload. Call dropped.", 25),
                QuizOption("Mumble incomprehensibly while crying softly", "AI routed call to automated suicide hotline. +15s penalty.", 15)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #35: THE MYSTERIOUS CAR DASHBOARD LIGHT",
            text = "An orange icon resembling a tiny submarine lights up on your speedometer. What does it signify?",
            isEvasive = false,
            options = listOf(
                QuizOption("Check Engine: The engine is still there; continue driving", "Ignorance is bliss until white smoke billows from radiator.", 10),
                QuizOption("Torpedoes armed in tube 1 and tube 2", "Automotive naval warfare unlocked. +20s penalty.", 20),
                QuizOption("Put a piece of black electrical tape over it so it stops bothering you", "The certified redneck engineering methodology.", 15),
                QuizOption("Your wallet is about to lose \$1,850 at the mechanic", "Financial premonition accurate. +25s labor fee.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #36: THE INBOX ZERO MIRAGE",
            text = "You achieved Inbox Zero at 4:59 PM. What happens at 5:01 PM?",
            isEvasive = false,
            options = listOf(
                QuizOption("14 urgent emails arrive marked HIGH PRIORITY with red exclamation marks", "The universe abhors an empty inbox. Equilibrium restored.", 10),
                QuizOption("CEO sends an email with subject line: 'Quick question'", "The two most terrifying words in corporate existence.", 15),
                QuizOption("Your server administrator re-indexes your mailbox and duplicates all 2018 mail", "Zombie emails reanimate from the trash folder.", 20),
                QuizOption("You wake up from your brief daydream; you have 18,402 unread emails", "Reality reasserts itself with crushing weight.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #37: THE USB FLASH DRIVE LABELS",
            text = "You have 5 identical black flash drives in your desk drawer. What is on the one labeled 'IMPORTANT'?",
            isEvasive = false,
            options = listOf(
                QuizOption("A corrupted Linux ISO from 2014 and 3 mp3 songs by Smash Mouth", "Archeological dig into your discarded digital youth.", 10),
                QuizOption("Your encrypted Bitcoin wallet private keys (password forgotten)", "Unrecoverable wealth stored on a \$4 plastic thumb drive.", 25),
                QuizOption("Photos of a friend's cat who passed away in 2016", "Nostalgia penalty. +15s emotional reflection delay.", 15),
                QuizOption("It is completely empty and unformatted", "Of course it is. Why would it be useful?", 20)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #38: THE BATHROOM AUTOMATIC FAUCET DANCE",
            text = "The infrared sensor faucet refuses to dispense water. What dance do you perform?",
            isEvasive = false,
            options = listOf(
                QuizOption("Aggressively karate-chop the air 2 inches under the nozzle", "Sensor watches your kung-fu routine with robotic apathy.", 10),
                QuizOption("Move hands in slow, sensual circular wave motions", "Romancing the plumbing fixture. Still dry.", 15),
                QuizOption("Use the adjacent sink whose water is boiling hot for no reason", "Third-degree burns sustained in airport restroom.", 20),
                QuizOption("Wipe hands on trousers and pretend you washed them", "Hygiene violation logged. -40 cleanliness score.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #39: THE TV REMOTE BATTERY RESURRECTION",
            text = "The remote control stops working. What is your first repair procedure?",
            isEvasive = false,
            options = listOf(
                QuizOption("Open the battery door and aggressively spin both AA batteries with thumb", "Physics defies explanation: it works for 3 more days.", 10),
                QuizOption("Slap the remote firmly against the couch armrest twice", "Percussive maintenance is an internationally recognized standard.", 15),
                QuizOption("Steal AA batteries from the smoke detector", "Fire safety hazard created. Fire department alerted.", 25),
                QuizOption("Get up and press the button on the TV itself like a caveman", "Physical exertion rejected. +20s laziness penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #40: THE IKEA FURNITURE ALLEN WRENCH SURPLUS",
            text = "After assembling the 'FJÄLLBO' bookcase, you discover 3 spare wooden dowels and 1 mystery screw. What do you do?",
            isEvasive = false,
            options = listOf(
                QuizOption("Shove them into the kitchen junk drawer with the other 40 Allen wrenches", "The junk drawer grows stronger each passing season.", 10),
                QuizOption("Live in constant dread that the bookcase will collapse at 3 AM", "Structural paranoia is justified; do not put heavy books on top.", 15),
                QuizOption("Blame Swedish engineering translation errors", "Swedish embassy files formal diplomatic protest.", 20),
                QuizOption("Eat the wooden dowel to destroy the evidence", "Termite digestive protocol initiated. +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #41: THE SMARTWATCH STEP COUNTER HACK",
            text = "It is 11:45 PM and your smartwatch says 9,842 steps. How do you reach 10,000?",
            isEvasive = false,
            options = listOf(
                QuizOption("Vigorously shake your wrist while lying horizontally in bed", "Deceiving your digital personal trainer. Shameful.", 10),
                QuizOption("Tape the watch to the ceiling fan and set to low speed", "Ceiling fan spins watch into drywall. Wall damage penalty.", 20),
                QuizOption("Attach watch to dog's collar and throw a tennis ball down the hall", "Canine fitness laundering verified.", 15),
                QuizOption("Accept defeat and weep into pillow", "Emotional breakdown logged. +25s comfort delay.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #42: THE HOTEL SHOWER TEMPERATURE DIAL",
            text = "You rotate the shower dial 1 millimeter to the left. What happens to the water temperature?",
            isEvasive = false,
            options = listOf(
                QuizOption("Shifts from arctic glacier ice directly into liquid magma volcanic lava", "The binary threshold of hotel hospitality plumbing.", 10),
                QuizOption("Water pressure drops to 3 agonizing drips per minute", "Shower head calcified with calcium deposits.", 15),
                QuizOption("Entire shower curtain is sucked inward and clings to your wet back", "The aerodynamic Bernoulli shower curtain trap.", 20),
                QuizOption("Room service knocks on door asking if you need extra towels", "Terrible timing. +25s embarrassment penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #43: THE CHIP BAG AIR CONTENT RATIO",
            text = "You open a family-size bag of potato chips. What percentage of the bag is nitrogen gas?",
            isEvasive = false,
            options = listOf(
                QuizOption("82% nitrogen gas; 18% crushed potato crumbs", "You purchased a bag of designer oxygen with free potato dust.", 10),
                QuizOption("Nitrogen preserves crispness, peasant", "Corporate snack food apologist detected. +15s tax.", 15),
                QuizOption("Zero, the bag is empty; someone ate it on the drive home", "Weak impulse control on road trips.", 20),
                QuizOption("Enough gas to inflate a hot air balloon across the English Channel", "Aeronautical snack food verified.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #44: THE SUPERMARKET FASTEST LANE TRAP",
            text = "You choose the checkout lane with only 1 customer holding 2 items. What happens?",
            isEvasive = false,
            options = listOf(
                QuizOption("Customer produces 47 expired paper coupons and writes a personal check", "Personal check in 2026? Cashier searches for a pen for 20 minutes.", 10),
                QuizOption("Price check on an organic avocado with missing barcode", "Manager summoned to produce section on intercom.", 15),
                QuizOption("Register runs out of receipt tape; cashier goes to lunch", "Abandon your groceries and walk into the sunset.", 20),
                QuizOption("You are in the lane reserved for store rewards card signups", "Trapped in credit card sales pitch. +25s penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #45: THE HEADPHONE CORD KNOTTING ANOMALY",
            text = "You put neatly coiled wired earphones into an empty coat pocket for 45 seconds. How many knots are formed?",
            isEvasive = false,
            options = listOf(
                QuizOption("A complex sailing knot capable of anchoring an aircraft carrier", "Pocket thermodynamics spontaneously produces topological knots.", 10),
                QuizOption("14 knots that defy non-Euclidean 4-dimensional topology", "Mathematicians flock to study your coat pocket.", 15),
                QuizOption("The cord somehow tangled itself around your house keys and a pack of gum", "Symbiotic pocket organism created.", 20),
                QuizOption("Just buy wireless earbuds and lose the left earbud on the train", "The modern consumer upgrade cycle. +25s expense.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #46: THE OFFICE REFRIGERATOR TUPPERWARE RELIC",
            text = "There is a plastic container in the back of the breakroom fridge labeled 'Dave - Dec 2021'. What is inside?",
            isEvasive = false,
            options = listOf(
                QuizOption("A new sentient fungal species capable of independent thought", "The mold has developed language and applied for union membership.", 10),
                QuizOption("Chili that has achieved geological fossilization", "Petrified beef stew dating to the late Holocene epoch.", 15),
                QuizOption("Dave hasn't worked at the company for 4 years", "Ghost of employees past haunting the lower shelf.", 20),
                QuizOption("Open it to find out and trigger biological evacuation of floor 3", "Biohazard containment protocol activated. +30s hazmat.", 30)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #47: THE PASSENGER SEAT PHANTOM BRAKE",
            text = "You are in the passenger seat. The driver approaches a red light at 50 mph. What does your right foot do?",
            isEvasive = false,
            options = listOf(
                QuizOption("Slam invisible floorboard brake pedal through the vehicle chassis", "Phantom braking reflex activated. Floor carpet dented.", 10),
                QuizOption("Grip the overhead grab handle ('Oh-Crap handle') with white knuckles", "Overhead handle load rating tested to structural limit.", 15),
                QuizOption("Pretend to look at phone to avoid witnessing imminent collision", "Ostriches and passengers share identical survival tactics.", 20),
                QuizOption("Critique the driver's braking curve using calculus", "Driver kicks you out on the highway shoulder. +25s walk.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #48: THE MICROWAVE POPCORN CRITICAL WINDOW",
            text = "You are listening to the kernel popping intervals. When do you stop the microwave?",
            isEvasive = false,
            options = listOf(
                QuizOption("2 seconds between pops, or your house smells like scorched carbon for 6 days", "The knife-edge balance between unpopped kernels and fire alarm.", 10),
                QuizOption("Let it run 10 seconds longer to get every single kernel", "Kitchen filled with black carcinogenic fog. Fire department en route.", 25),
                QuizOption("Stop early and enjoy 40 raw unpopped yellow dental hazards", "Dentist rejoices at upcoming crown replacement fee.", 15),
                QuizOption("Popcorn button on microwave actually works", "Mythical button that nobody has ever trusted. +20s penalty.", 20)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #49: THE ONLINE RECIPE LIFE STORY INTRO",
            text = "You searched for 'how to boil an egg'. How many paragraphs of family history must you scroll past?",
            isEvasive = false,
            options = listOf(
                QuizOption("14 pages about the author's grandmother's childhood in rural Tuscany", "I just want the cooking time, Susan! Not your spiritual awakening!", 10),
                QuizOption("37 pop-up video ads and 4 cookie permission dialogs", "Browser RAM consumption reaches 100%. Computer fans howling.", 15),
                QuizOption("Click 'Jump to Recipe' but page jumps back to top when ad loads", "The infinite web page layout shift torment.", 20),
                QuizOption("Give up and eat raw egg like Rocky Balboa", "Salmonella risk accepted. +25s emergency room penalty.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #50: THE CAR PARKING SPOT ILLUSION",
            text = "You spot an open parking space in a packed lot. You drive closer. What was hidden in the spot?",
            isEvasive = false,
            options = listOf(
                QuizOption("A tiny Fiat 500 or Mazda Miata parked all the way forward against curb", "The heartbreak of false hope in a shopping mall parking deck.", 10),
                QuizOption("A single bent supermarket shopping cart standing guard", "Shopping cart territory claimed. Honk in vain.", 15),
                QuizOption("A giant pothole filled with stagnant rainwater", "Suspension repair estimate: \$850. +20s delay.", 20),
                QuizOption("A motorcycle parked diagonally to maximize human misery", "Biker leaves note: 'Motorcycles are vehicles too'.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #51: THE PHONE LOW BATTERY ANXIETY ESCALATION",
            text = "Your phone battery drops from 2% to 1%. How much time do you have left?",
            isEvasive = false,
            options = listOf(
                QuizOption("Approximately 1.4 seconds before screen fades black mid-sentence", "The 1% battery estimate is a mathematical fabrication.", 10),
                QuizOption("Miraculously stays on 1% for 45 minutes while you panic", "Quantum tunneling keeps the CPU alive on residual static electricity.", 15),
                QuizOption("Phone shuts down and requires 10 minutes of charging before turning back on", "The black screen of digital abandonment.", 20),
                QuizOption("Plug in charger cable; charger cable only works at 43-degree bent angle", "Hold charger in exact twisted position without breathing.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #79: AUTOCORRECT REBELLION",
            text = "Your phone autocorrects 'ducking' to 'ducking' exactly 0 times in human history. Why?",
            isEvasive = false,
            options = listOf(
                QuizOption("Duck conservation society filed trademark claim.", "Humorous penalty logged. Duck conservation society filed trademark claim.", 10),
                QuizOption("Apple algorithms are puritanical.", "Sarcastic audit fee applied. Apple algorithms are puritanical.", 15),
                QuizOption("Swype keyboard had stroke.", "Philosophical distress noted. Swype keyboard had stroke.", 20),
                QuizOption("Speech-to-text gave up.", "Absurd conclusion reached. Speech-to-text gave up.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #80: THE BROWSER TAB OVERFLOW",
            text = "You have 142 tabs open in Google Chrome. Which one is playing audio?",
            isEvasive = false,
            options = listOf(
                QuizOption("The tiny speaker icon is hidden behind a 3-pixel tab sliver.", "Humorous penalty logged. The tiny speaker icon is hidden behind a 3-pixel tab sliver.", 10),
                QuizOption("Mute whole computer and sit in silence.", "Sarcastic audit fee applied. Mute whole computer and sit in silence.", 15),
                QuizOption("Task Manager -> End Task -> End Life.", "Philosophical distress noted. Task Manager -> End Task -> End Life.", 20),
                QuizOption("It is an advertisement for car insurance from 3 hours ago.", "Absurd conclusion reached. It is an advertisement for car insurance from 3 hours ago.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #81: THE FITTED BEDSHEET FOLDING MYTH",
            text = "How do you fold a fitted bedsheet with elastic corners?",
            isEvasive = false,
            options = listOf(
                QuizOption("Roll it into a frantic chaotic ball and shove into linen closet.", "Humorous penalty logged. Roll it into a frantic chaotic ball and shove into linen closet.", 10),
                QuizOption("Watch 4 YouTube tutorials and cry in the bedroom.", "Sarcastic audit fee applied. Watch 4 YouTube tutorials and cry in the bedroom.", 15),
                QuizOption("Hire a NASA origami consultant.", "Philosophical distress noted. Hire a NASA origami consultant.", 20),
                QuizOption("Burn the sheet and buy flat sheets only.", "Absurd conclusion reached. Burn the sheet and buy flat sheets only.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #82: THE STREAMING SERVICE BROWSING SPIRAL",
            text = "You sit down at 8:00 PM to watch a movie. At 9:45 PM, what are you watching?",
            isEvasive = false,
            options = listOf(
                QuizOption("Still scrolling through Netflix thumbnails while eating cold dinner.", "Humorous penalty logged. Still scrolling through Netflix thumbnails while eating cold dinner.", 10),
                QuizOption("Trailers for movies you saw 10 years ago.", "Sarcastic audit fee applied. Trailers for movies you saw 10 years ago.", 15),
                QuizOption("The menu background ambient drone noise.", "Philosophical distress noted. The menu background ambient drone noise.", 20),
                QuizOption("Gave up and went to sleep.", "Absurd conclusion reached. Gave up and went to sleep.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #83: THE AIRLINE BAGGAGE CAROUSEL WATCH",
            text = "Your suitcase is black with a generic luggage tag. 400 identical black suitcases appear. Which is yours?",
            isEvasive = false,
            options = listOf(
                QuizOption("Pick up stranger's suitcase and make awkward eye contact.", "Humorous penalty logged. Pick up stranger's suitcase and make awkward eye contact.", 10),
                QuizOption("The one with the tiny red ribbon tied to handle that fell off in cargo.", "Sarcastic audit fee applied. The one with the tiny red ribbon tied to handle that fell off in cargo.", 15),
                QuizOption("Your suitcase was rerouted to Honolulu; you are in Cleveland.", "Philosophical distress noted. Your suitcase was rerouted to Honolulu; you are in Cleveland.", 20),
                QuizOption("Wait until carousel stops and weep.", "Absurd conclusion reached. Wait until carousel stops and weep.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #84: THE COLD CALL ELEVATOR PITCH",
            text = "A LinkedIn connection messages: 'Great background! Would love to synergize your portfolio'. What is their product?",
            isEvasive = false,
            options = listOf(
                QuizOption("A multi-level marketing pyramid scheme selling essential oils.", "Humorous penalty logged. A multi-level marketing pyramid scheme selling essential oils.", 10),
                QuizOption("An automated web scraping tool that doesn't work.", "Sarcastic audit fee applied. An automated web scraping tool that doesn't work.", 15),
                QuizOption("Life coaching for displaced crypto bros.", "Philosophical distress noted. Life coaching for displaced crypto bros.", 20),
                QuizOption("They want to borrow \$40 on CashApp.", "Absurd conclusion reached. They want to borrow \$40 on CashApp.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #85: THE PHANTOM SMARTPHONE VIBRATION",
            text = "You feel a vibration against your right thigh. You check your pocket. What happened?",
            isEvasive = false,
            options = listOf(
                QuizOption("Phantom vibration syndrome; your thigh muscle twitched with digital anxiety.", "Humorous penalty logged. Phantom vibration syndrome; your thigh muscle twitched with digital anxiety.", 10),
                QuizOption("Phone was sitting on desk 5 feet away.", "Sarcastic audit fee applied. Phone was sitting on desk 5 feet away.", 15),
                QuizOption("It was a text from Domino's Pizza about 50% off.", "Philosophical distress noted. It was a text from Domino's Pizza about 50% off.", 20),
                QuizOption("Spider in your pocket. Run.", "Absurd conclusion reached. Spider in your pocket. Run.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #86: THE ZOOM MEETING EYE CONTACT ILLUSION",
            text = "When speaking on Zoom, where should your eyeballs actually look?",
            isEvasive = false,
            options = listOf(
                QuizOption("Directly into the tiny camera lens hole to appear sociopathic.", "Humorous penalty logged. Directly into the tiny camera lens hole to appear sociopathic.", 10),
                QuizOption("At your own tiny self-view window to check your hair for 40 minutes.", "Sarcastic audit fee applied. At your own tiny self-view window to check your hair for 40 minutes.", 15),
                QuizOption("At your dog sleeping on floor.", "Philosophical distress noted. At your dog sleeping on floor.", 20),
                QuizOption("Stare into middle distance like a philosopher.", "Absurd conclusion reached. Stare into middle distance like a philosopher.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #87: THE BLUETOOTH SPEAKER DISCONNECT",
            text = "Your phone disconnects from the living room Bluetooth speaker. Where did it reconnect?",
            isEvasive = false,
            options = listOf(
                QuizOption("To your sleeping spouse's AirPods upstairs at full volume.", "Humorous penalty logged. To your sleeping spouse's AirPods upstairs at full volume.", 10),
                QuizOption("To the neighbor's smart soundbar through the drywall.", "Sarcastic audit fee applied. To the neighbor's smart soundbar through the drywall.", 15),
                QuizOption("To a car passing by outside at 30 mph.", "Philosophical distress noted. To a car passing by outside at 30 mph.", 20),
                QuizOption("Audio defaulted to mute.", "Absurd conclusion reached. Audio defaulted to mute.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #88: THE HOTEL KEYCARD DEMAGNETIZATION",
            text = "You placed your plastic hotel keycard in the same pocket as your smartphone. What happened?",
            isEvasive = false,
            options = listOf(
                QuizOption("Card demagnetized immediately; take elevator of shame down to front desk.", "Humorous penalty logged. Card demagnetized immediately; take elevator of shame down to front desk.", 10),
                QuizOption("Front desk clerk looks at you with pity and sigh.", "Sarcastic audit fee applied. Front desk clerk looks at you with pity and sigh.", 15),
                QuizOption("Room door beeps red light 4 times.", "Philosophical distress noted. Room door beeps red light 4 times.", 20),
                QuizOption("Sleep in the hallway on the ice machine.", "Absurd conclusion reached. Sleep in the hallway on the ice machine.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #89: THE WEBP IMAGE DOWNLOAD BETRAYAL",
            text = "You right-click 'Save Image As' expecting a clean PNG. What format does Google download?",
            isEvasive = false,
            options = listOf(
                QuizOption(".webp file that Photoshop and Windows refuse to open.", "Humorous penalty logged. .webp file that Photoshop and Windows refuse to open.", 10),
                QuizOption("A 1-pixel transparent tracking gif.", "Sarcastic audit fee applied. A 1-pixel transparent tracking gif.", 15),
                QuizOption("HTML document containing 404 error.", "Philosophical distress noted. HTML document containing 404 error.", 20),
                QuizOption("Screenshot it with Snipping Tool out of spite.", "Absurd conclusion reached. Screenshot it with Snipping Tool out of spite.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #90: THE SELF-CHECKOUT VOICE AUDIT",
            text = "Self-checkout kiosk screams: 'UNEXPECTED ITEM IN BAGGING AREA'. What was the item?",
            isEvasive = false,
            options = listOf(
                QuizOption("A single gust of atmospheric breeze weighing 0.002 grams.", "Humorous penalty logged. A single gust of atmospheric breeze weighing 0.002 grams.", 10),
                QuizOption("Your reusable canvas tote bag you brought from home.", "Sarcastic audit fee applied. Your reusable canvas tote bag you brought from home.", 15),
                QuizOption("The weight of your existential sins.", "Philosophical distress noted. The weight of your existential sins.", 20),
                QuizOption("Flashing red light summons cashier across store.", "Absurd conclusion reached. Flashing red light summons cashier across store.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #91: THE REFRIGERATOR DOOR OPEN-CLOSE-REPEAT",
            text = "You opened the fridge 3 minutes ago and found nothing. Why are you opening it again?",
            isEvasive = false,
            options = listOf(
                QuizOption("Hoping your standards for acceptable food dropped low enough.", "Humorous penalty logged. Hoping your standards for acceptable food dropped low enough.", 10),
                QuizOption("Checking if gourmet pizza materialized out of quantum vacuum.", "Sarcastic audit fee applied. Checking if gourmet pizza materialized out of quantum vacuum.", 15),
                QuizOption("Staring blankly to cool down forehead.", "Philosophical distress noted. Staring blankly to cool down forehead.", 20),
                QuizOption("Lowering house temperature via appliance.", "Absurd conclusion reached. Lowering house temperature via appliance.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #92: THE CEILING FAN LIGHT STRING ROULETTE",
            text = "You pull the chain hanging from the ceiling fan. What does it do?",
            isEvasive = false,
            options = listOf(
                QuizOption("Switches fan from 100 mph helicopter speed to 101 mph; light remains off.", "Humorous penalty logged. Switches fan from 100 mph helicopter speed to 101 mph; light remains off.", 10),
                QuizOption("Tears chain directly out of socket housing.", "Sarcastic audit fee applied. Tears chain directly out of socket housing.", 15),
                QuizOption("Turns light off, turns fan on reverse.", "Philosophical distress noted. Turns light off, turns fan on reverse.", 20),
                QuizOption("Nothing. Pull other mystery chain.", "Absurd conclusion reached. Nothing. Pull other mystery chain.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #93: THE SMART TV KEYBOARD TYPING SLOWDOWN",
            text = "Typing 'THE SHAWSHANK REDEMPTION' with a television remote control arrow keys takes:",
            isEvasive = false,
            options = listOf(
                QuizOption("Approximately 14 minutes and 32 misclicks.", "Humorous penalty logged. Approximately 14 minutes and 32 misclicks.", 10),
                QuizOption("Select 'T', scroll 14 squares right for 'H', overshoot to 'K'.", "Sarcastic audit fee applied. Select 'T', scroll 14 squares right for 'H', overshoot to 'K'.", 15),
                QuizOption("Voice remote mishears as 'SpongeBob Season 4'.", "Philosophical distress noted. Voice remote mishears as 'SpongeBob Season 4'.", 20),
                QuizOption("Gave up; watched whatever was on cable.", "Absurd conclusion reached. Gave up; watched whatever was on cable.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #94: THE DENTIST SMALL-TALK PARADOX",
            text = "The dental hygienist has 4 sharp metal hooks and a suction tube in your mouth. What do they ask?",
            isEvasive = false,
            options = listOf(
                QuizOption("'So, have you planned any exciting summer vacations this year?'", "Humorous penalty logged. 'So, have you planned any exciting summer vacations this year?'", 10),
                QuizOption("'Are you flossing every day?' (while gums bleed profusely).", "Sarcastic audit fee applied. 'Are you flossing every day?' (while gums bleed profusely).", 15),
                QuizOption("'Open wider... no, wider... wider than that.'", "Philosophical distress noted. 'Open wider... no, wider... wider than that.'", 20),
                QuizOption("Gurgle incomprehensibly: 'Mmmph gllrrph yea'.", "Absurd conclusion reached. Gurgle incomprehensibly: 'Mmmph gllrrph yea'.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #95: THE CAR KEY IN IGNITION LOCKOUT",
            text = "You locked your keys inside the car while engine is running. What is playing on the radio?",
            isEvasive = false,
            options = listOf(
                QuizOption("Your most embarrassing guilty-pleasure pop song at maximum volume.", "Humorous penalty logged. Your most embarrassing guilty-pleasure pop song at maximum volume.", 10),
                QuizOption("Static on AM radio frequency 540.", "Sarcastic audit fee applied. Static on AM radio frequency 540.", 15),
                QuizOption("A podcast about how to prevent locking keys in cars.", "Philosophical distress noted. A podcast about how to prevent locking keys in cars.", 20),
                QuizOption("The car horn honking in rhythm.", "Absurd conclusion reached. The car horn honking in rhythm.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #96: THE ONLINE CLOTHING SIZE ROULETTE",
            text = "You ordered a 'Medium' cotton T-shirt from an online overseas retailer. What arrives?",
            isEvasive = false,
            options = listOf(
                QuizOption("A garment sized for a muscular squirrel or a medium-sized hamster.", "Humorous penalty logged. A garment sized for a muscular squirrel or a medium-sized hamster.", 10),
                QuizOption("A tent capable of sheltering a family of 6 during hurricane season.", "Sarcastic audit fee applied. A tent capable of sheltering a family of 6 during hurricane season.", 15),
                QuizOption("A shirt with one sleeve 4 inches longer than the other.", "Philosophical distress noted. A shirt with one sleeve 4 inches longer than the other.", 20),
                QuizOption("A pair of nylon socks with zero explanation.", "Absurd conclusion reached. A pair of nylon socks with zero explanation.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #97: THE OFFICE AIR CONDITIONING WAR",
            text = "Brenda from Accounting sets the office thermostat to 62°F (16.6°C). What must you wear to work?",
            isEvasive = false,
            options = listOf(
                QuizOption("A sub-zero arctic parka, wool mittens, and a hot water bottle.", "Humorous penalty logged. A sub-zero arctic parka, wool mittens, and a hot water bottle.", 10),
                QuizOption("Type emails with stiff, blue-tinted fingers while shivering.", "Sarcastic audit fee applied. Type emails with stiff, blue-tinted fingers while shivering.", 15),
                QuizOption("File formal OSHA freezing temperature complaint.", "Philosophical distress noted. File formal OSHA freezing temperature complaint.", 20),
                QuizOption("Smuggle ceramic space heater under desk until circuit breaker trips.", "Absurd conclusion reached. Smuggle ceramic space heater under desk until circuit breaker trips.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #98: THE PASSWORD COMPLEXITY CREATION EXTREME",
            text = "Password must contain: 1 uppercase, 1 lowercase, 1 number, 1 hieroglyph, and the atomic weight of Xenon.",
            isEvasive = false,
            options = listOf(
                QuizOption("Password accepted! (Next screen: Password must not match any password used since 1998).", "Humorous penalty logged. Password accepted! (Next screen: Password must not match any password used since 1998).", 10),
                QuizOption("Password must contain the name of your first pet's accountant.", "Sarcastic audit fee applied. Password must contain the name of your first pet's accountant.", 15),
                QuizOption("Write password on yellow sticky note stuck to monitor frame.", "Philosophical distress noted. Write password on yellow sticky note stuck to monitor frame.", 20),
                QuizOption("Click 'Forgot Password' every single login.", "Absurd conclusion reached. Click 'Forgot Password' every single login.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #99: THE BREAD LOAF HEEL REJECTION",
            text = "Two dry crust end-pieces ('heels') remain in the sliced bread bag. What is their fate?",
            isEvasive = false,
            options = listOf(
                QuizOption("Ignored by all household members until mold claims them.", "Humorous penalty logged. Ignored by all household members until mold claims them.", 10),
                QuizOption("Turned into croutons that nobody eats.", "Sarcastic audit fee applied. Turned into croutons that nobody eats.", 15),
                QuizOption("Eaten in quiet shame at 2 AM with peanut butter.", "Philosophical distress noted. Eaten in quiet shame at 2 AM with peanut butter.", 20),
                QuizOption("Given to ducks at the pond who also reject them.", "Absurd conclusion reached. Given to ducks at the pond who also reject them.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #100: THE SMART SPEAKER ACCIDENTAL ACTIVATION",
            text = "You said 'Hey, seriously...' to a family member. What did Alexa hear?",
            isEvasive = false,
            options = listOf(
                QuizOption("Alexa: 'Ordering 45 pounds of Himalayan pink rock salt.'", "Humorous penalty logged. Alexa: 'Ordering 45 pounds of Himalayan pink rock salt.'", 10),
                QuizOption("Alexa plays smooth jazz at volume 10.", "Sarcastic audit fee applied. Alexa plays smooth jazz at volume 10.", 15),
                QuizOption("Alexa starts whispering recipes for beef brisket.", "Philosophical distress noted. Alexa starts whispering recipes for beef brisket.", 20),
                QuizOption("Alexa: 'Sorry, I am having trouble understanding right now.'", "Absurd conclusion reached. Alexa: 'Sorry, I am having trouble understanding right now.'", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #101: THE COUCH CUSHION FINANCIAL HARVEST",
            text = "You stick your hand deep into the dark crevice between sofa cushions. What do you extract?",
            isEvasive = false,
            options = listOf(
                QuizOption("\$0.73 in sticky pennies, 1 french fry from 2022, and a TV remote missing battery cover.", "Humorous penalty logged. \$0.73 in sticky pennies, 1 french fry from 2022, and a TV remote missing battery cover.", 10),
                QuizOption("A forgotten guitar pick and 4 hair ties.", "Sarcastic audit fee applied. A forgotten guitar pick and 4 hair ties.", 15),
                QuizOption("Your car keys that have been missing for 3 weeks.", "Philosophical distress noted. Your car keys that have been missing for 3 weeks.", 20),
                QuizOption("A portal to the dimension of lost pens.", "Absurd conclusion reached. A portal to the dimension of lost pens.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #102: THE SHOWER THOUGHT PHILOSOPHICAL REVELATION",
            text = "At 7:15 AM under warm water, what Nobel-prize breakthrough idea enters your brain?",
            isEvasive = false,
            options = listOf(
                QuizOption("Lasagna is just spaghetti-flavored layer cake.", "Humorous penalty logged. Lasagna is just spaghetti-flavored layer cake.", 10),
                QuizOption("If you clean a vacuum cleaner, you become the vacuum cleaner.", "Sarcastic audit fee applied. If you clean a vacuum cleaner, you become the vacuum cleaner.", 15),
                QuizOption("Water in a bottle is water trapped in water.", "Philosophical distress noted. Water in a bottle is water trapped in water.", 20),
                QuizOption("Forgot idea the second you stepped on the bath mat.", "Absurd conclusion reached. Forgot idea the second you stepped on the bath mat.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #103: THE DENTAL FLOSS MORAL CONSCIENCE",
            text = "The dentist asks: 'How often do you floss?' What is the socially acceptable reply?",
            isEvasive = false,
            options = listOf(
                QuizOption("'Every single day, twice on weekends' (while bleeding everywhere).", "Humorous penalty logged. 'Every single day, twice on weekends' (while bleeding everywhere).", 10),
                QuizOption("'I floss whenever a piece of popcorn gets stuck.'", "Sarcastic audit fee applied. 'I floss whenever a piece of popcorn gets stuck.'", 15),
                QuizOption("'Is flossing still a thing?'", "Philosophical distress noted. 'Is flossing still a thing?'", 20),
                QuizOption("'My lawyer has advised me not to answer.'", "Absurd conclusion reached. 'My lawyer has advised me not to answer.'", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #104: THE MICROWAVE TURNTABLE ROTATION MISALIGNMENT",
            text = "Your coffee mug handle was facing front when you pressed start. Where is the handle when it finishes?",
            isEvasive = false,
            options = listOf(
                QuizOption("Facing directly against the scorching back wall of the microwave.", "Humorous penalty logged. Facing directly against the scorching back wall of the microwave.", 10),
                QuizOption("Handle has melted into the ceramic glaze.", "Sarcastic audit fee applied. Handle has melted into the ceramic glaze.", 15),
                QuizOption("Handle has rotated into the 4th dimension.", "Philosophical distress noted. Handle has rotated into the 4th dimension.", 20),
                QuizOption("Handle is burning hot; coffee inside is ice cold.", "Absurd conclusion reached. Handle is burning hot; coffee inside is ice cold.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #105: THE OFFICE WATER COOLER ENCOUNTER",
            text = "You make accidental eye contact with the VP of Marketing at the water cooler. How do you break the silence?",
            isEvasive = false,
            options = listOf(
                QuizOption("'Hot enough out there for ya?'", "Humorous penalty logged. 'Hot enough out there for ya?'", 10),
                QuizOption("'Working hard or hardly working?'", "Sarcastic audit fee applied. 'Working hard or hardly working?'", 15),
                QuizOption("'Sure is Tuesday.'", "Philosophical distress noted. 'Sure is Tuesday.'", 20),
                QuizOption("Spill water on your shoes and walk backward into elevator.", "Absurd conclusion reached. Spill water on your shoes and walk backward into elevator.", 25)
            )
        ),
        QuizQuestion(
            title = "VERIFICATION AUDIT #106: THE AIRLINE SEAT RECLINE DILEMMA",
            text = "The passenger in 14B reclines their seat 2 inches into your kneecaps. What is your reaction?",
            isEvasive = false,
            options = listOf(
                QuizOption("Grit teeth and aim personal air vent directly at their bald spot.", "Humorous penalty logged. Grit teeth and aim personal air vent directly at their bald spot.", 10),
                QuizOption("Jam knees into their seatback with hydraulic force.", "Sarcastic audit fee applied. Jam knees into their seatback with hydraulic force.", 15),
                QuizOption("Recline your own seat into 16B to start a chain reaction.", "Philosophical distress noted. Recline your own seat into 16B to start a chain reaction.", 20),
                QuizOption("Accept your fate as folded human accordion.", "Absurd conclusion reached. Accept your fate as folded human accordion.", 25)
            )
        )
    )

    /**
     * Draws between minCount (default 10) and maxCount (default 14) questions
     * randomly from the 106-question pool (strictly >= 10).
     */
    fun getRandomQuestions(minCount: Int = 10, maxCount: Int = 14): List<QuizQuestion> {
        val count = Random.nextInt(minCount, maxCount + 1).coerceIn(10, allQuestions.size)
        return allQuestions.shuffled().take(count)
    }
}
