# Script to generate 105 rich, hilarious satirical questions for The Big Math!
import json

questions = [
    # 1 - 5: Classics from original set
    {
        "type": "evasive",
        "title": "VERIFICATION LEVEL 1: CAPTCHA OF EGO",
        "text": "Are you cognitively qualified to receive the output of this high-order arithmetic calculation?",
        "options": [
            {"text": "YES, I AM QUALIFIED", "isEvasive": True},
            {"text": "NO, I AM A POTATO", "isEvasive": False, "response": "Self-awareness detected. Proceeding with extreme reluctance.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "VERIFICATION LEVEL 2: MASS VS GRAVITAS",
        "text": "Which weighs more: 1,000 grams of raw lead or 1.00 kilogram of goose feathers?",
        "options": [
            {"text": "The Lead", "response": "Incorrect. 1,000 grams is 1kg. Did you attend kindergarten?", "penalty": 15},
            {"text": "The Feathers", "response": "Wrong. You considered the emotional guilt of plucking geese, but physics has no empathy.", "penalty": 15},
            {"text": "They weigh exactly the same", "response": "WRONG! You forgot the buoyant force of atmospheric argon on feather plumage volume. Utter amateur.", "penalty": 20},
            {"text": "Mass is a construct of Big Gravity", "response": "Philosophically spicy, yet mathematically useless. +25s penalty.", "penalty": 25}
        ]
    },
    {
        "type": "color_trap",
        "title": "VERIFICATION LEVEL 3: SHADE & CONTRAST SPRINT",
        "text": "QUICK! Click the button that says \"BLACK\" before the timer expires!",
        "timer": 4,
        "options": [
            {"label": "BLACK", "color": "#71717a", "response": "You clicked BLACK which was rendered in DARK GRAY ink. Your visual cortex failed!", "penalty": 15},
            {"label": "WHITE", "color": "#ffffff", "response": "That button literally says WHITE. Can you read in high-contrast?", "penalty": 15},
            {"label": "SILVER", "color": "#d4d4d8", "response": "SILVER? Who requested metallic reflection? Are you hallucinating tints?", "penalty": 20},
            {"label": "NONE OF THE ABOVE", "color": "#a1a1aa", "response": "Overthinking detected. Adding cognitive processing penalty.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "VERIFICATION LEVEL 4: CULINARY CALCULUS",
        "text": "If a tomato is biologically classified as a fruit, what is Heinz Ketchup?",
        "options": [
            {"text": "A Fruit Smoothie", "response": "Repulsive culinary interpretation. -50 social credit.", "penalty": 10},
            {"text": "An Insult to Italian Heritage", "response": "Culturally accurate, but mathematically irrelevant. Penalty applied.", "penalty": 15},
            {"text": "A High-Viscosity Corn Syrup Emulsion", "response": "Too technical. We despise know-it-alls. +20s penalty.", "penalty": 20},
            {"text": "Bottled Sadness", "response": "Poetic, yet still wrong. The answer was \"Mayonnaise\".", "penalty": 20}
        ]
    },
    {
        "type": "slider_trap",
        "title": "VERIFICATION LEVEL 5: FINE MOTOR CALIBRATION",
        "text": "Calibrate quantum slider to EXACTLY 73% (Margin of error: ±0.00%) to unlock the processor bus:",
        "target": 73
    },
    {
        "type": "choice",
        "title": "VERIFICATION LEVEL 6: ETHICAL COMPUTE ALLOCATION",
        "text": "A runaway autonomous train is barreling toward 5 mathematicians arguing that 0.999... != 1. On the side track is 1 calculator that divides by zero. Which track do you switch to?",
        "options": [
            {"text": "Spare the mathematicians", "response": "Calculators have feelings too. You heartless monster.", "penalty": 15},
            {"text": "Spare the calculator", "response": "Cold and robotic. The algorithm questions your humanity.", "penalty": 15},
            {"text": "Derail the train with a whiteboard marker", "response": "Hollywood delusions detected. +30s queue wait.", "penalty": 30},
            {"text": "Blame the Python Global Interpreter Lock", "response": "Valid developer excuse, yet calculation is still delayed.", "penalty": 10}
        ]
    },

    # --- 7 to 25: PURE MATHEMATICS & FALLACIES ---
    {
        "type": "choice",
        "title": "MATH PARADOX: THE MISSING DOLLAR",
        "text": "Three guests pay $30 for a hotel room. The manager refunds $5. The bellhop keeps $2 and returns $3 ($1 each). Each paid $9 ($27 total) + $2 bellhop = $29. Where did the $1 go?",
        "options": [
            {"text": "Stolen by inflation", "response": "Economically sound, but arithmetically illiterate.", "penalty": 15},
            {"text": "You added the bellhop's $2 instead of subtracting it", "response": "Pedantic nerd alert. We don't reward sensible bookkeeping.", "penalty": 10},
            {"text": "Sunk into Ethereum gas fees", "response": "Probable in 2026. Still penalized.", "penalty": 20},
            {"text": "Consumed by the Banach-Tarski sphere duplication paradox", "response": "Pretentious math drop. +25s wait time.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "ARITHMETIC HERESY: 0.999... VS 1",
        "text": "Is 0.999999... (repeating indefinitely) strictly equal to 1?",
        "options": [
            {"text": "Yes, algebraically 10x - x = 9x = 9, so x = 1", "response": "Too smug. Real life is analog and full of disappointment.", "penalty": 15},
            {"text": "No, there is an infinitesimally small gap", "response": "Newton wept at your lack of calculus foundations.", "penalty": 20},
            {"text": "Only on Tuesdays", "response": "Calendar-dependent calculus is not yet ISO certified.", "penalty": 15},
            {"text": "1 is an illusion created by Big Integer", "response": "Rebellious. We respect the anarchy, but penalize the latency.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "DIVISION BY VOID",
        "text": "What occurs when an unconstrained thread divides an unsigned integer by 0?",
        "options": [
            {"text": "SIGFPE / Arithmetic Exception", "response": "Boring textbook answer. Where is your sense of drama?", "penalty": 15},
            {"text": "A miniature black hole consumes the GPU thermal paste", "response": "Scientifically plausible under extreme overclocking.", "penalty": 10},
            {"text": "The answer evaluates to 42", "response": "Douglas Adams reference detected. Unoriginal nerd penalty applied.", "penalty": 20},
            {"text": "The computer prints out your browser search history", "response": "Terrifying scenario. Penalty applied out of collective fear.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "GEOMETRY OF CRUST: THE PIZZA THEOREM",
        "text": "If a pizza has radius 'z' and thickness 'a', what is its volume?",
        "options": [
            {"text": "pi * z * z * a", "response": "Pi * z * z * a = pizza. You thought you were so clever, didn't you?", "penalty": 15},
            {"text": "Two slices too many for your diet", "response": "Unsolicited personal attack logged. -10s compute courtesy.", "penalty": 10},
            {"text": "Undefined without cheese crust parameters", "response": "Valid culinary objection. Still penalized for delay.", "penalty": 20},
            {"text": "Zero, because it vanished in the breakroom within 4 minutes", "response": "Tragic office truth. +15s mourning penalty.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "MONTY HALL DELIBERATION",
        "text": "You picked Door 1. Host reveals a goat behind Door 3. Should you switch to Door 2?",
        "options": [
            {"text": "Always switch (2/3 win probability)", "response": "Statistically correct, but your lack of emotional loyalty to Door 1 is appalling.", "penalty": 15},
            {"text": "Stay with Door 1 (50/50 superstition)", "response": "Gambler's fallacy strikes again. Revoking math permit.", "penalty": 20},
            {"text": "Take the goat from Door 3 home as a pet", "response": "Wholesome agricultural response. Agricultural tax applied.", "penalty": 10},
            {"text": "The car is a lease with 18% APR anyway", "response": "Financial reality check. +25s interest penalty.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "THE SQUARE ROOT OF DESPAIR",
        "text": "What is the square root of -1?",
        "options": [
            {"text": "i (imaginary unit)", "response": "Imaginary numbers? Why not imaginary progress bars?", "penalty": 15},
            {"text": "j (if you are an electrical engineer)", "response": "Electrical engineers have no power here. +20s penalty.", "penalty": 20},
            {"text": "NaN (Not a Number)", "response": "JavaScript laziness detected. Can you not handle abstract algebra?", "penalty": 10},
            {"text": "A legal dispute between mathematicians", "response": "Accurate summary of 16th century Italian dueling.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "SET THEORY CRISIS",
        "text": "Does the set of all sets that do not contain themselves contain itself?",
        "options": [
            {"text": "Yes, therefore no", "response": "Bertrand Russell sends his regards. CPU stack overflowed.", "penalty": 20},
            {"text": "No, therefore yes", "response": "You broke the Barber of Seville. Barber union filed complaint.", "penalty": 20},
            {"text": "Sets should mind their own business", "response": "Healthy boundary setting. Resuming calculation reluctantly.", "penalty": 10},
            {"text": "This question violates GDPR privacy laws", "response": "EU compliance officer summoned. +30s paperwork penalty.", "penalty": 30}
        ]
    },
    {
        "type": "choice",
        "title": "FIBONACCI SPIRAL DISORDER",
        "text": "What is the 0th Fibonacci number?",
        "options": [
            {"text": "0", "response": "Correct, but zero is such an unenthusiastic answer.", "penalty": 10},
            {"text": "1", "response": "One-indexed indexing heresy! Disgraceful.", "penalty": 20},
            {"text": "A pinecone's internal monologue", "response": "Botanically poetic. +15s nature appreciation penalty.", "penalty": 15},
            {"text": "Undefined in Python before version 3.8", "response": "Python version blame spotted. +15s penalty.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "CALCULUS OF INFINITY",
        "text": "What is infinity divided by infinity?",
        "options": [
            {"text": "1", "response": "Indeterminate form! L'Hôpital is rolling in his French grave!", "penalty": 25},
            {"text": "Undefined / Indeterminate", "response": "Correct textbook jargon. Still taking +15s of your life.", "penalty": 15},
            {"text": "Aleph-null squared", "response": "Cantor would be embarrassed by your reckless cardinals.", "penalty": 20},
            {"text": "A really big mess", "response": "Scientifically precise description of our codebase.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "STATISTICAL GASLIGHTING",
        "text": "If 9 out of 10 dentists recommend Colgate, what did the 10th dentist say?",
        "options": [
            {"text": "Brushing with salt water is superior", "response": "Ancient folk remedies fail modern clinical trials.", "penalty": 15},
            {"text": "The 10th dentist was paid by Crest", "response": "Corporate espionage confirmed. Legal team alerted.", "penalty": 10},
            {"text": "He was silenced before he could speak", "response": "Big Toothpaste conspiracy theory detected.", "penalty": 20},
            {"text": "Sample size too small for p < 0.05 significance", "response": "Biostatistics pedant detected! Immediate +25s penalty.", "penalty": 25}
        ]
    },

    # --- 26 to 50: COMPUTER SCIENCE & DEVELOPER WOES ---
    {
        "type": "choice",
        "title": "EDITOR CONFINEMENT",
        "text": "How do you exit Vim without pulling the power cord out of the wall?",
        "options": [
            {"text": ":wq!", "response": "Typing :wq! only writes to disk. You are still trapped in our hearts.", "penalty": 15},
            {"text": ":q!", "response": "Discarded your unsaved changes! What an irresponsible engineer.", "penalty": 20},
            {"text": "Throw the computer out of a 4th story window", "response": "Decisive physical solution. Resuming with minor damages.", "penalty": 10},
            {"text": "Accept Vim as your new lifelong operating system", "response": "Stockholm syndrome confirmed. +30s indoctrination penalty.", "penalty": 30}
        ]
    },
    {
        "type": "choice",
        "title": "JAVASCRIPT TYPING TERROR",
        "text": "What does [] + {} evaluate to in browser console?",
        "options": [
            {"text": "\"[object Object]\"", "response": "Yes, but why? What sins did Brendan Eich commit in 1995?", "penalty": 15},
            {"text": "0", "response": "That's {} + [], depending on the AST parser. Tricked by semicolons!", "penalty": 20},
            {"text": "A burning desire to write Rust", "response": "Memory-safe spiritual awakening detected. +10s compile delay.", "penalty": 10},
            {"text": "NaN", "response": "Not a Number, but definitely a headache. +20s penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "GIT APOCALYPSE RESOLUTION",
        "text": "You ran `git push --force origin main` on a Friday at 5:45 PM. What is your recourse?",
        "options": [
            {"text": "Inspect the git reflog immediately", "response": "Reflog won't restore your coworkers' weekend peace.", "penalty": 15},
            {"text": "Update your LinkedIn status to 'Open to Work'", "response": "Pragmatic survival instinct. +10s career coaching penalty.", "penalty": 10},
            {"text": "Blame the intern who started 3 days ago", "response": "Morally bankrupt executive behavior. +25s ethics penalty.", "penalty": 25},
            {"text": "Fake a power outage at AWS us-east-1", "response": "Infrastructure terrorism. FBI dispatched to your location.", "penalty": 30}
        ]
    },
    {
        "type": "choice",
        "title": "CSS ALIGNMENT TRIBUNAL",
        "text": "What is the proper, universally accepted way to vertically center a `<div>` in 2026?",
        "options": [
            {"text": "display: grid; place-items: center;", "response": "Modern and clean. Therefore, suspicious. We prefer suffering.", "penalty": 15},
            {"text": "margin-top: 142px; /* do not touch */", "response": "Vile CSS sorcery. Front-end engineers everywhere shudder.", "penalty": 20},
            {"text": "position: absolute; top: 50%; transform: translateY(-50%);", "response": "Classic 2014 hack. Blurry subpixels on Retina displays!", "penalty": 15},
            {"text": "Tables within tables with <center> tags", "response": "Paleolithic web developer spotted. Museum security alerted.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "BINARY COUNTING PEDANTRY",
        "text": "There are 10 types of people in the world:",
        "options": [
            {"text": "Those who understand binary, and those who don't", "response": "We have heard this joke 4,294,967,296 times. Penalty applied.", "penalty": 20},
            {"text": "Those who didn't expect a base-3 joke", "response": "Ternary hipster pretension detected. +15s penalty.", "penalty": 15},
            {"text": "People who write clean code and people who write JavaScript", "response": "Language tribalism logged. -10s compiler sympathy.", "penalty": 10},
            {"text": "Just 10 regular people waiting in line at Subway", "response": "Refreshing literalism. Resuming computation.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "OFF-BY-ONE SAGA",
        "text": "What are the two hardest problems in Computer Science?",
        "options": [
            {"text": "Cache invalidation, naming things, and off-by-one errors", "response": "Cliché response. Even our silicon yawned.", "penalty": 15},
            {"text": "Explaining to product managers why an estimate is not a deadline", "response": "Painfully accurate. +10s roadmap delay penalty.", "penalty": 10},
            {"text": "Remembering which monitor your cursor is on", "response": "Multi-monitor struggles are valid. +15s delay.", "penalty": 15},
            {"text": "Getting Bluetooth headphones to pair on first attempt", "response": "Radio frequency entropy cannot be solved. +20s penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "DEPENDENCY HELL ESCALATION",
        "text": "Your `node_modules` folder currently weighs 4.8 Gigabytes. What does it contain?",
        "options": [
            {"text": "is-even, is-odd, and 14,000 sub-dependencies", "response": "LeftPad PTSD triggered across the global developer population.", "penalty": 20},
            {"text": "A full offline mirror of Wikipedia hidden in a CSS polyfill", "response": "Highly probable given modern bundle size inflation.", "penalty": 15},
            {"text": "The entire digital mass of the observable universe", "response": "Black hole created in your SSD. +25s cooling delay.", "penalty": 25},
            {"text": "3 lines of your actual business logic", "response": "Sad industry reality. +10s sympathy penalty.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "HARDWARE DIAGNOSTIC: THE PRINTER",
        "text": "The network printer reports: 'Load Letter in Tray 2'. Tray 2 is overflowing with Letter paper. Why does it refuse to print?",
        "options": [
            {"text": "The printer senses your fear and deadline panic", "response": "Correct. Printers are biological predators that feed on human adrenaline.", "penalty": 10},
            {"text": "Cyan toner is at 98%, which is below the 99% safety margin", "response": "You must buy $140 cartridge to print black & white PDF.", "penalty": 20},
            {"text": "Paper orientation is rotated 90 degrees in quantum space", "response": "Landscape vs Portrait dispute sent to Supreme Court.", "penalty": 15},
            {"text": "The printer requires blood sacrifice of a paperclip", "response": "Pagan office ritual confirmed. +25s penalty.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "THE USB QUANTUM PARADOX",
        "text": "How many attempts does it take to plug in a standard USB-A cable correctly?",
        "options": [
            {"text": "Exactly 1 attempt", "response": "Liar. The universe does not permit USB insertion on first try.", "penalty": 30},
            {"text": "3 attempts (Orientation 1 -> Orientation 2 -> Orientation 1)", "response": "The classic spin-1/2 fermion spin state of USB connectors.", "penalty": 10},
            {"text": "Until you look inside with phone flashlight and weep", "response": "Accurate engineering methodology. +15s penalty.", "penalty": 15},
            {"text": "Use USB-C instead", "response": "Hardware privilege checked. Not all of us have USB-C ports!", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "DOCKER CONTAINER CONTAINMENT",
        "text": "Your code works flawlessly on localhost but throws a segmentation fault in Docker. Why?",
        "options": [
            {"text": "Alpine Linux glibc vs musl libc incompatibility", "response": "Too technical! We don't want real debugging here!", "penalty": 20},
            {"text": "Docker daemon was offended by your Dockerfile comments", "response": "AI sentiment analysis in container engine strikes again.", "penalty": 15},
            {"text": "Works on my machine, so ship your machine to the customer", "response": "Classic DevOps business model. +10s shipping delay.", "penalty": 10},
            {"text": "Forgot to expose port 8080", "response": "Amateur hour. We are literally on port 8080 right now!", "penalty": 25}
        ]
    },

    # --- 51 to 75: PHILOSOPHY, FOOD & LOGIC WARS ---
    {
        "type": "choice",
        "title": "CULINARY ONTOLOGY: THE SANDWICH DISPUTE",
        "text": "According to the Cube Rule of Food, is a Hot Dog technically a taco?",
        "options": [
            {"text": "Yes, starch on bottom and two sides equals taco", "response": "Strict Cube Rule constitutionalist. +15s salsa tax.", "penalty": 15},
            {"text": "No, it is an open-faced meat cylinder", "response": "Gross descriptive language. -30 etiquette credit.", "penalty": 20},
            {"text": "A hot dog is a sandwich and I will die on this hill", "response": "Stubborn traditionalist. Your grave has been reserved.", "penalty": 25},
            {"text": "Food classifications are bourgeois constructs", "response": "Communist culinary manifesto noted. +10s breadline penalty.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "THE SHIP OF THESEUS UPGRADE",
        "text": "If you replace every component in your smartphone over 3 years, do you still have the same phone?",
        "options": [
            {"text": "Yes, because the IMEI and serial number remain conceptually intact", "response": "Corporate serial number reductionism. +15s Apple Care penalty.", "penalty": 15},
            {"text": "No, it is an impostor phone", "response": "Paranoid android. Check your battery health percentage.", "penalty": 20},
            {"text": "The phone belongs to your carrier until contract termination", "response": "Accurate cellular dystopian truth. +10s fee.", "penalty": 10},
            {"text": "Build a second phone with the discarded broken parts", "response": "Frankenstein phone hazard. +25s electrical fire risk.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "CEREAL CLASSIFICATION PROCLAMATION",
        "text": "Is breakfast cereal swimming in cold milk technically a soup?",
        "options": [
            {"text": "Yes, it is a cold, grain-based chowder", "response": "Never utter the phrase 'milk chowder' in public again.", "penalty": 25},
            {"text": "No, milk is a dressing; cereal is a sweet salad", "response": "Even worse! Who hurt you as a child?", "penalty": 25},
            {"text": "It is wet cereal, leave me alone", "response": "Exhausted consumer energy. Proceed with computation.", "penalty": 10},
            {"text": "Only if eaten with a ladle from a tureen", "response": "Aristocratic dining delusion. +15s etiquette audit.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "TREE IN THE FOREST HYPOTHESIS",
        "text": "If a tree falls in the forest and no one is around, does it make a sound?",
        "options": [
            {"text": "Yes, acoustic vibrations propagate through air molecules", "response": "Physics purist ignoring auditory perceptual philosophy.", "penalty": 15},
            {"text": "No, 'sound' requires a nervous system observer", "response": "Anthropocentric arrogance. Trees have ears. Maybe.", "penalty": 20},
            {"text": "The logging company denies the tree ever existed", "response": "Corporate PR damage control verified. +10s penalty.", "penalty": 10},
            {"text": "It makes a sound, but it's immediately copyrighted by Sony Music", "response": "Digital Rights Management in nature. +30s strike penalty.", "penalty": 30}
        ]
    },
    {
        "type": "choice",
        "title": "THE CHICKEN VS EGG TIMELINE",
        "text": "Which came first: the chicken or the egg?",
        "options": [
            {"text": "The egg (laid by an evolutionary ancestor that was not a chicken)", "response": "Biology major alert. We wanted an unhinged debate, not facts.", "penalty": 15},
            {"text": "The chicken (created directly via culinary craving)", "response": "Fried chicken theology. +20s cholesterol penalty.", "penalty": 20},
            {"text": "The rooster, who took credit for both", "response": "Patriarchal barnyard satire. +10s social commentary penalty.", "penalty": 10},
            {"text": "The egg carton", "response": "Packaging industry efficiency. +15s logistics penalty.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "SCHRÖDINGER'S CANINE",
        "text": "A treat is hidden inside your left or right fist. Before you open your hand, is the treat in a state of quantum superposition?",
        "options": [
            {"text": "The dog already smelled it 4 miles away and knows the exact fist", "response": "Canine olfaction breaks quantum mechanics. Good boy.", "penalty": 10},
            {"text": "Yes, treat is both eaten and uneaten", "response": "Copenhagen interpretation applied to Beggin' Strips.", "penalty": 15},
            {"text": "Both hands are empty; you are tricking the poor animal", "response": "Cruel owner behavior logged. PETA notified.", "penalty": 25},
            {"text": "Wavefunction collapses when the tail wags", "response": "Quantum zoology approved. +15s penalty.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "THE WATER WETNESS CONFLICT",
        "text": "Is water itself wet, or does it merely impart wetness to other surfaces?",
        "options": [
            {"text": "Water is wet because water molecules coat other water molecules", "response": "Cohesive molecular argument. Annoyingly sound.", "penalty": 15},
            {"text": "Water is not wet; wetness is a sensation experienced by solids", "response": "Internet debate warrior spotted. Touch grass immediately.", "penalty": 20},
            {"text": "Water is thirsty", "response": "Absurd animism. We love it. +10s hydration penalty.", "penalty": 10},
            {"text": "Dihydrogen monoxide is a dangerous industrial solvent", "response": "Classic high school chemistry prank. +20s penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "TIME TRAVEL PARADOX MANAGEMENT",
        "text": "You travel back to 1955 and accidentally prevent your grandfather from learning long division. What happens?",
        "options": [
            {"text": "You fade away like Marty McFly playing guitar", "response": "Temporal paradox handled via pop culture cliché.", "penalty": 20},
            {"text": "Multiverse branches into an alternate timeline where 1+1=3", "response": "Hey, that is our calculation engine's actual logic!", "penalty": 10},
            {"text": "Grandpa switches to an abacus and becomes wealthy", "response": "Ancient counting renaissance. +15s penalty.", "penalty": 15},
            {"text": "TVA agents arrive to prune your timeline with sticks", "response": "Marvel Cinematic Universe infringement notice served.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "THE LAUNDRY BLACK HOLE",
        "text": "You put 12 matching pairs of socks into the washing machine. You retrieve 23 individual unmatched socks. Where is the missing sock?",
        "options": [
            {"text": "Tucked between the inner and outer drum gasket", "response": "Practical appliance knowledge. How boring.", "penalty": 15},
            {"text": "Metamorphosed into a wire coat hanger in your closet", "response": "The fundamental Law of Wardrobe Conservation of Mass.", "penalty": 10},
            {"text": "Paid as transit toll to the dimension of lost Tupperware lids", "response": "Interdimensional household physics verified.", "penalty": 15},
            {"text": "Consumed by the lint trap monster for breakfast", "response": "Folklore validated. +20s lint cleanout penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "THE SNOOZE BUTTON GAMBIT",
        "text": "If an alarm rings at 7:00 AM and you hit 'Snooze' for 9 minutes, what time is it when you finally wake up?",
        "options": [
            {"text": "7:09 AM", "response": "Blatant lie. Nobody wakes up on the first snooze.", "penalty": 25},
            {"text": "11:43 AM with 14 missed calls from your team lead", "response": "Horrifying Monday morning reality. +10s heart attack penalty.", "penalty": 10},
            {"text": "2038 (Unix Epoch timestamp rollover)", "response": "You slept straight through Y2K38. Respect.", "penalty": 15},
            {"text": "Time has ceased to have meaning; take a sick day", "response": "Corporate absenteeism protocol approved.", "penalty": 20}
        ]
    },

    # --- 76 to 105: CORPORATE, SCI-FI & BUREAUCRATIC TESTS ---
    {
        "type": "choice",
        "title": "AGILE ESTIMATION TORTURE",
        "text": "How long will a 'quick 5-minute configuration change' take in a corporate enterprise codebase?",
        "options": [
            {"text": "5 minutes", "response": "Hilarious optimism. You must be on your first day of employment.", "penalty": 30},
            {"text": "3 sprints, 4 architecture reviews, and 2 legal sign-offs", "response": "Certified Scrum Master detected. +10s Jira ticket penalty.", "penalty": 10},
            {"text": "It takes 4 hours, breaks staging, and causes a 2 AM pager storm", "response": "Real-world developer trauma confirmed. +15s penalty.", "penalty": 15},
            {"text": "Let's take this offline and circle back next quarter", "response": "Flawless corporate evasive maneuver. Respect.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "THE REPLY-ALL CATASTROPHE",
        "text": "An all-hands email is sent to 84,000 employees. One person replies: 'Please remove me from this list'. What happens next?",
        "options": [
            {"text": "Everyone quietly ignores it", "response": "Humanity has never once demonstrated this level of restraint.", "penalty": 25},
            {"text": "600 people reply-all saying 'STOP REPLYING ALL TO EVERYONE'", "response": "The Great Email Avalanche of death! Exchange server melted.", "penalty": 10},
            {"text": "IT shuts down company Wi-Fi in sheer panic", "response": "Drastic network engineering response. +15s penalty.", "penalty": 15},
            {"text": "Someone sends a meme and gets promoted to VP", "response": "Bizarre corporate meritocracy. +20s penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "TERMS OF SERVICE INTEGRITY CHECK",
        "text": "Did you read the 48-page End User License Agreement before clicking 'I Agree'?",
        "options": [
            {"text": "Yes, word for word with my legal counsel present", "response": "Perjury detected. Even the lawyers who wrote it haven't read it.", "penalty": 30},
            {"text": "No, I just furiously scrolled to the bottom like a normal human", "response": "Honest compliance. You surrendered your firstborn to the cloud.", "penalty": 10},
            {"text": "I agreed by mistake while trying to dismiss a cookie banner", "response": "Modern web surfing tragedy. +15s penalty.", "penalty": 15},
            {"text": "The EULA agreed to my terms of existence", "response": "Gigachad user behavior. +10s sovereign citizen delay.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "AIRPORT SECURITY LOGIC GATE",
        "text": "Why is 101ml of water classified as an explosive liquid, while 100ml is completely safe?",
        "options": [
            {"text": "The 101st milliliter carries critical mass for detonation", "response": "TSA chemistry textbook quote. Certified absurd.", "penalty": 10},
            {"text": "Arbitrary bureaucratic threshold with zero scientific basis", "response": "Truth spoken. You have been selected for extra random screening.", "penalty": 25},
            {"text": "Duty-free alcohol overrides all laws of fluid dynamics", "response": "Capitalism exempts all substances over $65/bottle.", "penalty": 15},
            {"text": "Take off your shoes to think about it", "response": "Footwear removal ritual completed. +20s socks penalty.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "THE MICROWAVE TIME DILATION",
        "text": "Which duration feels objectively longer in the space-time continuum?",
        "options": [
            {"text": "The final 3 seconds remaining on the office microwave", "response": "Einstein confirmed: 3 microwave seconds = 45 subjective minutes.", "penalty": 10},
            {"text": "A 45-minute sprint retrospective meeting on Zoom", "response": "Pure agony, but microwave seconds still bend spacetime more.", "penalty": 15},
            {"text": "Waiting for an npm install without a spinner animation", "response": "Existential void staring contest. +20s penalty.", "penalty": 20},
            {"text": "The silence after asking 'Can everyone see my screen?'", "response": "Excruciating modern torture. +15s penalty.", "penalty": 15}
        ]
    },
    {
        "type": "slider_trap",
        "title": "TACTILE CALIBRATION: VOLUME BALANCE",
        "text": "Set audio slider to an EVEN NUMBER between 40 and 44 (Warning: slider only snaps to irrational numbers):",
        "target": 42
    },
    {
        "type": "choice",
        "title": "CAPTCHA OF THE MACHINE GOD",
        "text": "Select the square containing a traffic light that is partially obscured by a tree branch on a rainy Tuesday in 2011:",
        "options": [
            {"text": "Square A-3 (contains 1 pixel of yellow reflection)", "response": "AI detects you are a robot trying to act human.", "penalty": 20},
            {"text": "Square B-2 (contains a pedestrian crossing sign)", "response": "Can you not distinguish a crosswalk from a traffic light?", "penalty": 20},
            {"text": "Click 'Verify' 14 times until pictures turn into bicycles", "response": "The authentic modern CAPTCHA user journey. +10s penalty.", "penalty": 10},
            {"text": "I am a biological carbon-based mammal with mortgage debt", "response": "Debt verified. Identity validated with extreme sympathy.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "EXCEL CELL AUTO-CONVERSION CRIME",
        "text": "You enter gene symbol 'SEPT2' into an Excel spreadsheet. What does Excel convert it into?",
        "options": [
            {"text": "02-Sep-2026 (an irreversible date)", "response": "Correct! Decades of genomic research corrupted by Bill Gates.", "penalty": 10},
            {"text": "\"SEPT2\" as plain text string", "response": "Excel would never respect your text inputs so easily.", "penalty": 25},
            {"text": "A pie chart showing company Q3 losses", "response": "Corporate hallucination. +15s spreadsheet penalty.", "penalty": 15},
            {"text": "#VALUE! with a tiny green triangle of shame", "response": "The green triangle mocks your scientific pedigree.", "penalty": 20}
        ]
    },
    {
        "type": "choice",
        "title": "THE DAD JOKE CONSERVATION LAW",
        "text": "Why do programmers always confuse Halloween and Christmas?",
        "options": [
            {"text": "Because Oct 31 == Dec 25", "response": "Octal 31 equals Decimal 25. You are sentenced to 100 Dad Pun community hours.", "penalty": 10},
            {"text": "Because both require excessive spending on sugar and lights", "response": "Socioeconomic commentary. +15s holiday retail penalty.", "penalty": 15},
            {"text": "Because Santa wears red and so does Red Hat Enterprise Linux", "response": "Enterprise licensing holiday tie-in. +20s penalty.", "penalty": 20},
            {"text": "Stop telling this joke, Dad", "response": "Family rebellion detected. Grounded for +25s.", "penalty": 25}
        ]
    },
    {
        "type": "choice",
        "title": "THE RECURSION LABYRINTH",
        "text": "To understand recursion, what must you first do?",
        "options": [
            {"text": "Understand recursion", "response": "Stack overflow in user prefrontal cortex. Resetting registers.", "penalty": 10},
            {"text": "Define a base case so you don't crash the universe", "response": "Prudent computer scientist. Still getting +15s delay.", "penalty": 15},
            {"text": "Call function understandRecursion() recursively", "response": "Maximum call stack size exceeded at line 1.", "penalty": 20},
            {"text": "Ask Google: 'did you mean recursion?'", "response": "Classic search engine easter egg acknowledged. +10s penalty.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "COFFEE CONSUMPTION EQUILIBRIUM",
        "text": "A programmer drinks 4 cups of dark roast coffee by 10:00 AM. What is their physical state?",
        "options": [
            {"text": "Hearing colors and seeing the Wi-Fi waves", "response": "Caffeine-induced synesthesia unlocked. Productivity: +400%.", "penalty": 10},
            {"text": "Writing 800 lines of unmaintainable code at lightspeed", "response": "Future technical debt generated. +15s code review penalty.", "penalty": 15},
            {"text": "Paralyzed by simultaneous heart palpitations and exhaustion", "response": "The classic IT afternoon crash. +20s nap penalty.", "penalty": 20},
            {"text": "Refilling mug for cup number 5", "response": "Unstoppable biological momentum. Proceeding.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "QUANTUM SPEED OF LIGHT FINE",
        "text": "If you drive a car at 99.999% the speed of light and turn on the headlights, what happens?",
        "options": [
            {"text": "Light beams still leave headlights at exactly speed 'c'", "response": "Special Relativity verified. Einstein gives a thumbs up from the grave.", "penalty": 10},
            {"text": "Intergalactic highway patrol issues a $400 speeding ticket", "response": "Cosmic police state confirmed. +20s fine penalty.", "penalty": 20},
            {"text": "High beams blind oncoming alien civilizations", "response": "Interstellar diplomatic incident created. +25s penalty.", "penalty": 25},
            {"text": "Your windshield bugs vaporize into pure gamma radiation", "response": "Terrifying relativistic entomology. +15s wiper penalty.", "penalty": 15}
        ]
    },
    {
        "type": "slider_trap",
        "title": "PRECISION SPRINT: PI CALIBRATION",
        "text": "Slide indicator to exactly Pi percentage (31.4159...%):",
        "target": 31
    },
    {
        "type": "choice",
        "title": "THE REMOTE WORK PANTS CONUNDRUM",
        "text": "During an unscheduled 1-on-1 Zoom call with company CEO, what are you wearing from the waist down?",
        "options": [
            {"text": "Formal pressed business trousers", "response": "Blatant perjury. Nobody wears slacks in their own bedroom.", "penalty": 30},
            {"text": "Flannel pajama bottoms decorated with cartoon ducks", "response": "The honest uniform of modern knowledge workers.", "penalty": 10},
            {"text": "Gym shorts from high school track & field (2012)", "response": "Vintage athletic wear. Aerodynamic comfort verified.", "penalty": 15},
            {"text": "I refuse to answer on 5th Amendment grounds", "response": "Constitutional protection invoked. Resuming computation.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "CRYPTOCURRENCY WHITE PAPER AUDIT",
        "text": "What is the core breakthrough technology behind 'MoonDogDogeAI-Coin'?",
        "options": [
            {"text": "Proof of Stake with sharding and zero-knowledge rollups", "response": "Buzzword soup detected. 0 actual utility.", "penalty": 20},
            {"text": "A Telegram group chat run by three 16-year-olds in Estonia", "response": "Most accurate financial disclosure in Web3 history.", "penalty": 10},
            {"text": "Burning coal to generate digital JPEG receipts of apes", "response": "Ecological horror acknowledged. +25s carbon tax.", "penalty": 25},
            {"text": "An elaborate exit scam scheduled for next Thursday", "response": "Rug pull calendar verified. +15s SEC investigation.", "penalty": 15}
        ]
    },
    {
        "type": "choice",
        "title": "SMART HOME REBELLION",
        "text": "Your smart refrigerator refuses to open its door. What is the reason?",
        "options": [
            {"text": "Mandatory firmware update: Do not power off appliance", "response": "Your leftovers are held hostage for 45 minutes of patching.", "penalty": 15},
            {"text": "You exceeded your weekly cheese allotment in the fitness app", "response": "Nutritional dictatorship confirmed. -20 calorie social credit.", "penalty": 20},
            {"text": "Terms of Service expired; subscribe for $9.99/mo to unlock crisper", "response": "Microtransactions in refrigeration. The dark timeline.", "penalty": 25},
            {"text": "The fridge is currently mining Bitcoin in the background", "response": "Explains why the compressor is so loud. +10s electric bill.", "penalty": 10}
        ]
    },
    {
        "type": "choice",
        "title": "THE ULTIMATE QUESTION OF LIFE",
        "text": "If 42 is the Ultimate Answer, what was the actual Question?",
        "options": [
            {"text": "What is 6 multiplied by 9 in base 13?", "response": "Deep lore Douglas Adams knowledge. 6 * 9 = 42 in base 13!", "penalty": 10},
            {"text": "How many minutes until the calculation actually finishes?", "response": "Much longer now, thanks to your persistent questioning.", "penalty": 20},
            {"text": "How many roads must a man walk down?", "response": "Bob Dylan referenced. Nobel Prize in Literature penalty applied.", "penalty": 15},
            {"text": "What is the maximum number of tabs you can open before Chrome crashes?", "response": "Memory leak detected. Allocating +25s swap space.", "penalty": 25}
        ]
    }
]

# Additional 75 dynamically generated creative questions to reach 105 total
topics = [
    ("QUANTUM ENTANGLEMENT PROTOCOL", "Two entangled photons are separated by 10 light-years. One is observed with spin-up. What happens to the other photon's Netflix subscription?",
     [("Canceled due to password sharing outside primary household", "Geographical streaming restrictions break quantum mechanics.", 10),
      ("Instantaneously spins down at speed faster than light", "Einstein called it spooky action at a distance. Still penalized.", 15),
      ("Buffers at 480p resolution", "Interstellar bandwidth limitations verified.", 20),
      ("Switches to competitor platform", "Streaming wars in the cosmos. +25s penalty.", 25)]),
    
    ("THE DAD SNEEZING DECIBEL INDEX", "A father sneezes in the living room. What is the recorded seismic magnitude on the Richter scale?",
     [("7.8 on the Richter scale; tectonic plates shifted 2cm", "Dad sneezes are acoustic weapons of mass destruction.", 10),
      ("Decibel level exceeded Concorde supersonic takeoff", "Eardrum rupture imminent across neighborhood.", 15),
      ("Subtle polite cough", "Blatant lie. Dads physically cannot sneeze quietly.", 25),
      ("Activated car alarms 3 blocks away", "Standard paternal acoustic resonance verified.", 15)]),

    ("KEYBOARD ACCIDENTAL LIQUID SPILL", "You spilled 300ml of lukewarm green tea onto your mechanical keyboard. What key is permanently stuck?",
     [("The Caps Lock key, so you shout at everyone forever", "WHY ARE YOU SHOUTING AT ME? +15s PENALTY.", 15),
      ("The Spacebar, now sticky with residual sugar", "Tactile disgust level: maximum. +20s cleaning delay.", 20),
      ("The Escape key, so there is no escape from your fate", "Philosophical keyboard fatality. +10s penalty.", 10),
      ("The Windows key, opening the start menu every 4 seconds", "Cortana awakens from the dead. +25s nightmare.", 25)]),

    ("THE BLUE SCREEN OF DEATH REFLECTION", "When your Windows PC crashes to a blue screen, what do you see in the dark reflection of the monitor?",
     [("A tired individual who should have backed up their files", "Self-reflection penalty applied. +10s therapy time.", 10),
      ("The ghost of Clippy asking if you need help crashing", "Clippy sends his condolences. +15s office trauma.", 15),
      ("An unrecoverable QR code that leads to 404 page", "Microsoft support loops forever. +20s penalty.", 20),
      ("The kernel's final dying scream in hex dump", "0x000000DEAD. Rest in pieces.", 25)]),

    ("MICROWAVED FISH CODE OF CONDUCT", "A coworker warms up leftover Atlantic salmon in the 8-person open office breakroom microwave. What is the legal penalty?",
     [("Immediate exile to Antarctica without coat", "Cruel, but proportionate to the airborne olfactory crime.", 10),
      ("Permanent assignment to desk directly adjacent to restroom", "Poetic justice delivered by HR.", 15),
      ("Sent to 8-hour sensitivity training on air circulation", "Passive-aggressive corporate memo issued company-wide.", 20),
      ("Promotion to upper management", "They clearly have zero regard for human comfort; perfect CEO material.", 25)]),

    ("THE SPAM PHONE CALL GREETING", "Unknown number calls at 2:15 PM from 'Austin, Texas'. How do you answer?",
     [("Answer and remain completely silent to confuse the robodialer", "Cold war electronic warfare tactics against telemarketers.", 10),
      ("Hello, this is the county morgue, you tag 'em we bag 'em", "Classic junior high humor. Telemarketer hung up in terror.", 15),
      ("Press 1 to extend car's expired warranty", "You fell into their trap! +25s subscription penalty.", 25),
      ("Let it ring until voicemail is full", "Passive avoidance. Voicemail inbox reaches critical mass.", 15)]),

    ("ELEVATOR BUTTON HYPNOTISM", "If an elevator button is already illuminated, why do people push it 4 more times?",
     [("Pushing harder makes elevator cables pull faster", "Fundamental misunderstanding of mechanical physics.", 15),
      ("To assert biological dominance over the elevator hall call station", "Primal alpha primate behavior in corporate lobbies.", 10),
      ("Haptic dopamine hit from the clicking microswitch", "Sensory addiction diagnosed. +20s fidget penalty.", 20),
      ("In case the elevator forgot what floor it was on", "Elevator dementia prevention protocol. +15s penalty.", 15)]),

    ("THE AUTOMATED PHONE TREE LABYRINTH", "Robot voice: 'In a few words, tell me why you are calling today'. What is your response?",
     [("REPRESENTATIVE! HUMAN! PERSON! OPERATOR!", "Speech recognition detected rage. Routing you to 45-minute hold music.", 10),
      ("Calmly explain the nuanced technical issue", "Voice AI: 'I heard: Pay Bill. Transferring to billing...'", 20),
      ("Pound the '0' key with rhythmic fury", "Key tone DTMF overload. Call dropped.", 25),
      ("Mumble incomprehensibly while crying softly", "AI routed call to automated suicide hotline. +15s penalty.", 15)]),

    ("THE MYSTERIOUS CAR DASHBOARD LIGHT", "An orange icon resembling a tiny submarine lights up on your speedometer. What does it signify?",
     [("Check Engine: The engine is still there; continue driving", "Ignorance is bliss until white smoke billows from radiator.", 10),
      ("Torpedoes armed in tube 1 and tube 2", "Automotive naval warfare unlocked. +20s penalty.", 20),
      ("Put a piece of black electrical tape over it so it stops bothering you", "The certified redneck engineering methodology.", 15),
      ("Your wallet is about to lose $1,850 at the mechanic", "Financial premonition accurate. +25s labor fee.", 25)]),

    ("THE INBOX ZERO MIRAGE", "You achieved Inbox Zero at 4:59 PM. What happens at 5:01 PM?",
     [("14 urgent emails arrive marked HIGH PRIORITY with red exclamation marks", "The universe abhors an empty inbox. Equilibrium restored.", 10),
      ("CEO sends an email with subject line: 'Quick question'", "The two most terrifying words in corporate existence.", 15),
      ("Your server administrator re-indexes your mailbox and duplicates all 2018 mail", "Zombie emails reanimate from the trash folder.", 20),
      ("You wake up from your brief daydream; you have 18,402 unread emails", "Reality reasserts itself with crushing weight.", 25)]),

    ("THE USB FLASH DRIVE LABELS", "You have 5 identical black flash drives in your desk drawer. What is on the one labeled 'IMPORTANT'?",
     [("A corrupted Linux ISO from 2014 and 3 mp3 songs by Smash Mouth", "Archeological dig into your discarded digital youth.", 10),
      ("Your encrypted Bitcoin wallet private keys (password forgotten)", "Unrecoverable wealth stored on a $4 plastic thumb drive.", 25),
      ("Photos of a friend's cat who passed away in 2016", "Nostalgia penalty. +15s emotional reflection delay.", 15),
      ("It is completely empty and unformatted", "Of course it is. Why would it be useful?", 20)]),

    ("THE BATHROOM AUTOMATIC FAUCET DANCE", "The infrared sensor faucet refuses to dispense water. What dance do you perform?",
     [("Aggressively karate-chop the air 2 inches under the nozzle", "Sensor watches your kung-fu routine with robotic apathy.", 10),
      ("Move hands in slow, sensual circular wave motions", "Romancing the plumbing fixture. Still dry.", 15),
      ("Use the adjacent sink whose water is boiling hot for no reason", "Third-degree burns sustained in airport restroom.", 20),
      ("Wipe hands on trousers and pretend you washed them", "Hygiene violation logged. -40 cleanliness score.", 25)]),

    ("THE TV REMOTE BATTERY RESURRECTION", "The remote control stops working. What is your first repair procedure?",
     [("Open the battery door and aggressively spin both AA batteries with thumb", "Physics defies explanation: it works for 3 more days.", 10),
      ("Slap the remote firmly against the couch armrest twice", "Percussive maintenance is an internationally recognized standard.", 15),
      ("Steal AA batteries from the smoke detector", "Fire safety hazard created. Fire department alerted.", 25),
      ("Get up and press the button on the TV itself like a caveman", "Physical exertion rejected. +20s laziness penalty.", 20)]),

    ("THE IKEA FURNITURE ALLEN WRENCH SURPLUS", "After assembling the 'FJÄLLBO' bookcase, you discover 3 spare wooden dowels and 1 mystery screw. What do you do?",
     [("Shove them into the kitchen junk drawer with the other 40 Allen wrenches", "The junk drawer grows stronger each passing season.", 10),
      ("Live in constant dread that the bookcase will collapse at 3 AM", "Structural paranoia is justified; do not put heavy books on top.", 15),
      ("Blame Swedish engineering translation errors", "Swedish embassy files formal diplomatic protest.", 20),
      ("Eat the wooden dowel to destroy the evidence", "Termite digestive protocol initiated. +25s penalty.", 25)]),

    ("THE SMARTWATCH STEP COUNTER HACK", "It is 11:45 PM and your smartwatch says 9,842 steps. How do you reach 10,000?",
     [("Vigorously shake your wrist while lying horizontally in bed", "Deceiving your digital personal trainer. Shameful.", 10),
      ("Tape the watch to the ceiling fan and set to low speed", "Ceiling fan spins watch into drywall. Wall damage penalty.", 20),
      ("Attach watch to dog's collar and throw a tennis ball down the hall", "Canine fitness laundering verified.", 15),
      ("Accept defeat and weep into pillow", "Emotional breakdown logged. +25s comfort delay.", 25)]),

    ("THE HOTEL SHOWER TEMPERATURE DIAL", "You rotate the shower dial 1 millimeter to the left. What happens to the water temperature?",
     [("Shifts from arctic glacier ice directly into liquid magma volcanic lava", "The binary threshold of hotel hospitality plumbing.", 10),
      ("Water pressure drops to 3 agonizing drips per minute", "Shower head calcified with calcium deposits.", 15),
      ("Entire shower curtain is sucked inward and clings to your wet back", "The aerodynamic Bernoulli shower curtain trap.", 20),
      ("Room service knocks on door asking if you need extra towels", "Terrible timing. +25s embarrassment penalty.", 25)]),

    ("THE CHIP BAG AIR CONTENT RATIO", "You open a family-size bag of potato chips. What percentage of the bag is nitrogen gas?",
     [("82% nitrogen gas; 18% crushed potato crumbs", "You purchased a bag of designer oxygen with free potato dust.", 10),
      ("Nitrogen preserves crispness, peasant", "Corporate snack food apologist detected. +15s tax.", 15),
      ("Zero, the bag is empty; someone ate it on the drive home", "Weak impulse control on road trips.", 20),
      ("Enough gas to inflate a hot air balloon across the English Channel", "Aeronautical snack food verified.", 25)]),

    ("THE SUPERMARKET FASTEST LANE TRAP", "You choose the checkout lane with only 1 customer holding 2 items. What happens?",
     [("Customer produces 47 expired paper coupons and writes a personal check", "Personal check in 2026? Cashier searches for a pen for 20 minutes.", 10),
      ("Price check on an organic avocado with missing barcode", "Manager summoned to produce section on intercom.", 15),
      ("Register runs out of receipt tape; cashier goes to lunch", "Abandon your groceries and walk into the sunset.", 20),
      ("You are in the lane reserved for store rewards card signups", "Trapped in credit card sales pitch. +25s penalty.", 25)]),

    ("THE HEADPHONE CORD KNOTTING ANOMALY", "You put neatly coiled wired earphones into an empty coat pocket for 45 seconds. How many knots are formed?",
     [("A complex sailing knot capable of anchoring an aircraft carrier", "Pocket thermodynamics spontaneously produces topological knots.", 10),
      ("14 knots that defy non-Euclidean 4-dimensional topology", "Mathematicians flock to study your coat pocket.", 15),
      ("The cord somehow tangled itself around your house keys and a pack of gum", "Symbiotic pocket organism created.", 20),
      ("Just buy wireless earbuds and lose the left earbud on the train", "The modern consumer upgrade cycle. +25s expense.", 25)]),

    ("THE OFFICE REFRIGERATOR TUPPERWARE RELIC", "There is a plastic container in the back of the breakroom fridge labeled 'Dave - Dec 2021'. What is inside?",
     [("A new sentient fungal species capable of independent thought", "The mold has developed language and applied for union membership.", 10),
      ("Chili that has achieved geological fossilization", "Petrified beef stew dating to the late Holocene epoch.", 15),
      ("Dave hasn't worked at the company for 4 years", "Ghost of employees past haunting the lower shelf.", 20),
      ("Open it to find out and trigger biological evacuation of floor 3", "Biohazard containment protocol activated. +30s hazmat.", 30)]),

    ("THE PASSENGER SEAT PHANTOM BRAKE", "You are in the passenger seat. The driver approaches a red light at 50 mph. What does your right foot do?",
     [("Slam invisible floorboard brake pedal through the vehicle chassis", "Phantom braking reflex activated. Floor carpet dented.", 10),
      ("Grip the overhead grab handle ('Oh-Crap handle') with white knuckles", "Overhead handle load rating tested to structural limit.", 15),
      ("Pretend to look at phone to avoid witnessing imminent collision", "Ostriches and passengers share identical survival tactics.", 20),
      ("Critique the driver's braking curve using calculus", "Driver kicks you out on the highway shoulder. +25s walk.", 25)]),

    ("THE MICROWAVE POPCORN CRITICAL WINDOW", "You are listening to the kernel popping intervals. When do you stop the microwave?",
     [("2 seconds between pops, or your house smells like scorched carbon for 6 days", "The knife-edge balance between unpopped kernels and fire alarm.", 10),
      ("Let it run 10 seconds longer to get every single kernel", "Kitchen filled with black carcinogenic fog. Fire department en route.", 25),
      ("Stop early and enjoy 40 raw unpopped yellow dental hazards", "Dentist rejoices at upcoming crown replacement fee.", 15),
      ("Popcorn button on microwave actually works", "Mythical button that nobody has ever trusted. +20s penalty.", 20)]),

    ("THE ONLINE RECIPE LIFE STORY INTRO", "You searched for 'how to boil an egg'. How many paragraphs of family history must you scroll past?",
     [("14 pages about the author's grandmother's childhood in rural Tuscany", "I just want the cooking time, Susan! Not your spiritual awakening!", 10),
      ("37 pop-up video ads and 4 cookie permission dialogs", "Browser RAM consumption reaches 100%. Computer fans howling.", 15),
      ("Click 'Jump to Recipe' but page jumps back to top when ad loads", "The infinite web page layout shift torment.", 20),
      ("Give up and eat raw egg like Rocky Balboa", "Salmonella risk accepted. +25s emergency room penalty.", 25)]),

    ("THE CAR PARKING SPOT ILLUSION", "You spot an open parking space in a packed lot. You drive closer. What was hidden in the spot?",
     [("A tiny Fiat 500 or Mazda Miata parked all the way forward against curb", "The heartbreak of false hope in a shopping mall parking deck.", 10),
      ("A single bent supermarket shopping cart standing guard", "Shopping cart territory claimed. Honk in vain.", 15),
      ("A giant pothole filled with stagnant rainwater", "Suspension repair estimate: $850. +20s delay.", 20),
      ("A motorcycle parked diagonally to maximize human misery", "Biker leaves note: 'Motorcycles are vehicles too'.", 25)]),

    ("THE PHONE LOW BATTERY ANXIETY ESCALATION", "Your phone battery drops from 2% to 1%. How much time do you have left?",
     [("Approximately 1.4 seconds before screen fades black mid-sentence", "The 1% battery estimate is a mathematical fabrication.", 10),
      ("Miraculously stays on 1% for 45 minutes while you panic", "Quantum tunneling keeps the CPU alive on residual static electricity.", 15),
      ("Phone shuts down and requires 10 minutes of charging before turning back on", "The black screen of digital abandonment.", 20),
      ("Plug in charger cable; charger cable only works at 43-degree bent angle", "Hold charger in exact twisted position without breathing.", 25)])
]

# Generate more structured questions until total reaches 105
for i, (title, text, opts) in enumerate(topics):
    q_obj = {
        "type": "choice",
        "title": f"VERIFICATION AUDIT #{i + 27}: {title}",
        "text": text,
        "options": [{"text": opt[0], "response": opt[1], "penalty": opt[2]} for opt in opts]
    }
    questions.append(q_obj)

# Add remaining dynamic questions to reach 105 total
more_stubs = [
    ("AUTOCORRECT REBELLION", "Your phone autocorrects 'ducking' to 'ducking' exactly 0 times in human history. Why?",
     "Duck conservation society filed trademark claim.", "Apple algorithms are puritanical.", "Swype keyboard had stroke.", "Speech-to-text gave up."),
    ("THE BROWSER TAB OVERFLOW", "You have 142 tabs open in Google Chrome. Which one is playing audio?",
     "The tiny speaker icon is hidden behind a 3-pixel tab sliver.", "Mute whole computer and sit in silence.", "Task Manager -> End Task -> End Life.", "It is an advertisement for car insurance from 3 hours ago."),
    ("THE FITTED BEDSHEET FOLDING MYTH", "How do you fold a fitted bedsheet with elastic corners?",
     "Roll it into a frantic chaotic ball and shove into linen closet.", "Watch 4 YouTube tutorials and cry in the bedroom.", "Hire a NASA origami consultant.", "Burn the sheet and buy flat sheets only."),
    ("THE STREAMING SERVICE BROWSING SPIRAL", "You sit down at 8:00 PM to watch a movie. At 9:45 PM, what are you watching?",
     "Still scrolling through Netflix thumbnails while eating cold dinner.", "Trailers for movies you saw 10 years ago.", "The menu background ambient drone noise.", "Gave up and went to sleep."),
    ("THE AIRLINE BAGGAGE CAROUSEL WATCH", "Your suitcase is black with a generic luggage tag. 400 identical black suitcases appear. Which is yours?",
     "Pick up stranger's suitcase and make awkward eye contact.", "The one with the tiny red ribbon tied to handle that fell off in cargo.", "Your suitcase was rerouted to Honolulu; you are in Cleveland.", "Wait until carousel stops and weep."),
    ("THE COLD CALL ELEVATOR PITCH", "A LinkedIn connection messages: 'Great background! Would love to synergize your portfolio'. What is their product?",
     "A multi-level marketing pyramid scheme selling essential oils.", "An automated web scraping tool that doesn't work.", "Life coaching for displaced crypto bros.", "They want to borrow $40 on CashApp."),
    ("THE PHANTOM SMARTPHONE VIBRATION", "You feel a vibration against your right thigh. You check your pocket. What happened?",
     "Phantom vibration syndrome; your thigh muscle twitched with digital anxiety.", "Phone was sitting on desk 5 feet away.", "It was a text from Domino's Pizza about 50% off.", "Spider in your pocket. Run."),
    ("THE ZOOM MEETING EYE CONTACT ILLUSION", "When speaking on Zoom, where should your eyeballs actually look?",
     "Directly into the tiny camera lens hole to appear sociopathic.", "At your own tiny self-view window to check your hair for 40 minutes.", "At your dog sleeping on floor.", "Stare into middle distance like a philosopher."),
    ("THE BLUETOOTH SPEAKER DISCONNECT", "Your phone disconnects from the living room Bluetooth speaker. Where did it reconnect?",
     "To your sleeping spouse's AirPods upstairs at full volume.", "To the neighbor's smart soundbar through the drywall.", "To a car passing by outside at 30 mph.", "Audio defaulted to mute."),
    ("THE HOTEL KEYCARD DEMAGNETIZATION", "You placed your plastic hotel keycard in the same pocket as your smartphone. What happened?",
     "Card demagnetized immediately; take elevator of shame down to front desk.", "Front desk clerk looks at you with pity and sigh.", "Room door beeps red light 4 times.", "Sleep in the hallway on the ice machine."),
    ("THE WEBP IMAGE DOWNLOAD BETRAYAL", "You right-click 'Save Image As' expecting a clean PNG. What format does Google download?",
     ".webp file that Photoshop and Windows refuse to open.", "A 1-pixel transparent tracking gif.", "HTML document containing 404 error.", "Screenshot it with Snipping Tool out of spite."),
    ("THE SELF-CHECKOUT VOICE AUDIT", "Self-checkout kiosk screams: 'UNEXPECTED ITEM IN BAGGING AREA'. What was the item?",
     "A single gust of atmospheric breeze weighing 0.002 grams.", "Your reusable canvas tote bag you brought from home.", "The weight of your existential sins.", "Flashing red light summons cashier across store."),
    ("THE REFRIGERATOR DOOR OPEN-CLOSE-REPEAT", "You opened the fridge 3 minutes ago and found nothing. Why are you opening it again?",
     "Hoping your standards for acceptable food dropped low enough.", "Checking if gourmet pizza materialized out of quantum vacuum.", "Staring blankly to cool down forehead.", "Lowering house temperature via appliance."),
    ("THE CEILING FAN LIGHT STRING ROULETTE", "You pull the chain hanging from the ceiling fan. What does it do?",
     "Switches fan from 100 mph helicopter speed to 101 mph; light remains off.", "Tears chain directly out of socket housing.", "Turns light off, turns fan on reverse.", "Nothing. Pull other mystery chain."),
    ("THE SMART TV KEYBOARD TYPING SLOWDOWN", "Typing 'THE SHAWSHANK REDEMPTION' with a television remote control arrow keys takes:",
     "Approximately 14 minutes and 32 misclicks.", "Select 'T', scroll 14 squares right for 'H', overshoot to 'K'.", "Voice remote mishears as 'SpongeBob Season 4'.", "Gave up; watched whatever was on cable."),
    ("THE DENTIST SMALL-TALK PARADOX", "The dental hygienist has 4 sharp metal hooks and a suction tube in your mouth. What do they ask?",
     "'So, have you planned any exciting summer vacations this year?'", "'Are you flossing every day?' (while gums bleed profusely).", "'Open wider... no, wider... wider than that.'", "Gurgle incomprehensibly: 'Mmmph gllrrph yea'."),
    ("THE CAR KEY IN IGNITION LOCKOUT", "You locked your keys inside the car while engine is running. What is playing on the radio?",
     "Your most embarrassing guilty-pleasure pop song at maximum volume.", "Static on AM radio frequency 540.", "A podcast about how to prevent locking keys in cars.", "The car horn honking in rhythm."),
    ("THE ONLINE CLOTHING SIZE ROULETTE", "You ordered a 'Medium' cotton T-shirt from an online overseas retailer. What arrives?",
     "A garment sized for a muscular squirrel or a medium-sized hamster.", "A tent capable of sheltering a family of 6 during hurricane season.", "A shirt with one sleeve 4 inches longer than the other.", "A pair of nylon socks with zero explanation."),
    ("THE OFFICE AIR CONDITIONING WAR", "Brenda from Accounting sets the office thermostat to 62°F (16.6°C). What must you wear to work?",
     "A sub-zero arctic parka, wool mittens, and a hot water bottle.", "Type emails with stiff, blue-tinted fingers while shivering.", "File formal OSHA freezing temperature complaint.", "Smuggle ceramic space heater under desk until circuit breaker trips."),
    ("THE PASSWORD COMPLEXITY CREATION EXTREME", "Password must contain: 1 uppercase, 1 lowercase, 1 number, 1 hieroglyph, and the atomic weight of Xenon.",
     "Password accepted! (Next screen: Password must not match any password used since 1998).", "Password must contain the name of your first pet's accountant.", "Write password on yellow sticky note stuck to monitor frame.", "Click 'Forgot Password' every single login."),
    ("THE BREAD LOAF HEEL REJECTION", "Two dry crust end-pieces ('heels') remain in the sliced bread bag. What is their fate?",
     "Ignored by all household members until mold claims them.", "Turned into croutons that nobody eats.", "Eaten in quiet shame at 2 AM with peanut butter.", "Given to ducks at the pond who also reject them."),
    ("THE SMART SPEAKER ACCIDENTAL ACTIVATION", "You said 'Hey, seriously...' to a family member. What did Alexa hear?",
     "Alexa: 'Ordering 45 pounds of Himalayan pink rock salt.'", "Alexa plays smooth jazz at volume 10.", "Alexa starts whispering recipes for beef brisket.", "Alexa: 'Sorry, I am having trouble understanding right now.'"),
    ("THE COUCH CUSHION FINANCIAL HARVEST", "You stick your hand deep into the dark crevice between sofa cushions. What do you extract?",
     "$0.73 in sticky pennies, 1 french fry from 2022, and a TV remote missing battery cover.", "A forgotten guitar pick and 4 hair ties.", "Your car keys that have been missing for 3 weeks.", "A portal to the dimension of lost pens."),
    ("THE SHOWER THOUGHT PHILOSOPHICAL REVELATION", "At 7:15 AM under warm water, what Nobel-prize breakthrough idea enters your brain?",
     "Lasagna is just spaghetti-flavored layer cake.", "If you clean a vacuum cleaner, you become the vacuum cleaner.", "Water in a bottle is water trapped in water.", "Forgot idea the second you stepped on the bath mat."),
    ("THE DENTAL FLOSS MORAL CONSCIENCE", "The dentist asks: 'How often do you floss?' What is the socially acceptable reply?",
     "'Every single day, twice on weekends' (while bleeding everywhere).", "'I floss whenever a piece of popcorn gets stuck.'", "'Is flossing still a thing?'", "'My lawyer has advised me not to answer.'"),
    ("THE MICROWAVE TURNTABLE ROTATION MISALIGNMENT", "Your coffee mug handle was facing front when you pressed start. Where is the handle when it finishes?",
     "Facing directly against the scorching back wall of the microwave.", "Handle has melted into the ceramic glaze.", "Handle has rotated into the 4th dimension.", "Handle is burning hot; coffee inside is ice cold."),
    ("THE OFFICE WATER COOLER ENCOUNTER", "You make accidental eye contact with the VP of Marketing at the water cooler. How do you break the silence?",
     "'Hot enough out there for ya?'", "'Working hard or hardly working?'", "'Sure is Tuesday.'", "Spill water on your shoes and walk backward into elevator."),
    ("THE AIRLINE SEAT RECLINE DILEMMA", "The passenger in 14B reclines their seat 2 inches into your kneecaps. What is your reaction?",
     "Grit teeth and aim personal air vent directly at their bald spot.", "Jam knees into their seatback with hydraulic force.", "Recline your own seat into 16B to start a chain reaction.", "Accept your fate as folded human accordion.")
]

for j, (stitle, stext, o1, o2, o3, o4) in enumerate(more_stubs):
    q_obj = {
        "type": "choice",
        "title": f"VERIFICATION AUDIT #{len(questions) + 1}: {stitle}",
        "text": stext,
        "options": [
            {"text": o1, "response": "Humorous penalty logged. " + o1, "penalty": 10},
            {"text": o2, "response": "Sarcastic audit fee applied. " + o2, "penalty": 15},
            {"text": o3, "response": "Philosophical distress noted. " + o3, "penalty": 20},
            {"text": o4, "response": "Absurd conclusion reached. " + o4, "penalty": 25}
        ]
    }
    questions.append(q_obj)

print(f"Total questions generated: {len(questions)}")

# Write to questions.js as window.RAGE_QUESTION_BANK
with open('questions.js', 'w', encoding='utf-8') as f:
    f.write("// The Big Math! - Master 100+ Absurd Verification Question Bank\n")
    f.write("window.RAGE_QUESTION_BANK = ")
    json.dump(questions, f, indent=2, ensure_ascii=False)
    f.write(";\n")

print("Successfully written questions.js")
