/*
i promise you
i had this much free time
and i did all of this myself
*/

/*
START OF VACATION CODE
*/
var seasonOfChoice = getText("seasonOfChoice");
var environmentType = getText("environmentType");
var age = 13;
var sound;
var soundOn;
var resetButtonTimesClicked = 0;
var firstTimeClickAboutButton = true;
var shouldGoBackToNameScreen = true;

console.log("Welcome to the all-in-one app! Here, you can get the best recommended place to go for your vacation.\nOr... if you want, you can do some math.");

onEvent("startButton", "click", function() {
  setScreen("questionScreen");
  playAppSound();
  setText("age", age);
  console.log("Choose your desired season, environment, and age!");
});

onEvent("aboutButton", "click", function() {
  setScreen("creditsScreen");
  playAppSound();
  if (firstTimeClickAboutButton == true) { // if it is the user's first time clicking the about button, then the program will send a message into the console. if not, then it will do nothing.
    console.log("The all-in-one app. Created, coded and decorated by: Dillon.");
    firstTimeClickAboutButton = false;
  }
});

onEvent("settingsButton", "click", function() {
  setScreen("settingsScreen");
  playAppSound();
});

onEvent("homeButtonSettingsScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
  setProperty("resetAppConfirmationLabel", "hidden", true);
  resetButtonTimesClicked = 0;
});

onEvent("backButtonCreditsScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
});

onEvent("backButtonQuestionScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
});

onEvent("supriseButton", "click", function() {
  supriseMe();
  playAppSound();
  console.log("Enjoy your suprise. :)");
});

onEvent("nextButton", "click", function() {
  updateOptions();
  /* If the age is valid, in the debug console, it will display what the user inputs, and give them the best location based off of that information.
  If the age is a word that can be converted into a number, then it will also do the same thing.
  */
  if (age >= 0 && age <= 122
  || age == "one" || age == "one".toUpperCase()
  || age == "two" || age == "two".toUpperCase()
  || age == "three" || age == "three".toUpperCase()
  || age == "four" || age == "four".toUpperCase()
  || age == "five" || age == "five".toUpperCase()
  || age == "six" || age == "six".toUpperCase()
  || age == "seven" || age == "seven".toUpperCase()
  || age == "eight" || age == "eight".toUpperCase()
  || age == "nine" || age == "nine".toUpperCase()
  || age == "ten" || age == "ten".toUpperCase()
  || age == "eleven" || age == "eleven".toUpperCase()
  || age == "twelve" || age == "twelve".toUpperCase()
  || age == "thirteen" || age == "thirteen".toUpperCase()
  || age == "fourteen" || age == "fourteen".toUpperCase()
  || age == "fifteen" || age == "fifteen".toUpperCase()
  || age == "sixteen" || age == "sixteen".toUpperCase()
  || age == "seventeen" || age == "seventeen".toUpperCase()
  || age == "eighteen" || age == "eighteen".toUpperCase()
  || age == "nineteen" || age == "nineteen".toUpperCase()
  || age == "twenty" || age == "twenty".toUpperCase()
  || age == "thirty" || age == "thirty".toUpperCase()
  || age == "fourty" || age == "fourty".toUpperCase()
  || age == "fifty" || age == "fifty".toUpperCase()
  || age == "sixty" || age == "sixty".toUpperCase()
  || age == "seventy" || age == "seventy".toUpperCase()
  || age == "eighty" || age == "eighty".toUpperCase()
  || age == "ninety" || age == "ninety".toUpperCase()) {
    fixAge();
    console.log("Your input: \n" + "Age: " + age + "\nSeason: " + seasonOfChoice + "\nEnvironment: " + environmentType);
    displayBestOption();
    console.log("Enjoy your stay. :)");
  } else { // If the age is NOT valid, then the program will go to the invalid age, and the user will have to try again and input a valid age.
    setScreen("invalidAgeScreen");
    console.log("Oh no! It looks like you entered an invalid age. You cannot enter anything less than 0, above 123, or anything that isn't a number.\nYou entered: " + age);
    fixAge();
  }
  playAppSound();
});

onEvent("backButtonHotelScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

onEvent("backButtonHotPlaceScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

onEvent("backButtonParkScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

onEvent("backButtonSnowyMountainsScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

onEvent("backButtonSummerAndBeachScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

// Goes through the user's inputs and decides which location would best suit the user.
function displayBestOption() {
  if (seasonOfChoice == "Summer" && environmentType == "Beach") {
    setScreen("summerAndBeachScreen");
  } else if (seasonOfChoice == "Summer" && environmentType != "Beach") {
    setScreen("hotPlaceScreen");
  } else if (seasonOfChoice == "Fall" && environmentType == "Park" || seasonOfChoice == "Fall") {
    setScreen("parkScreen");
  } else if (age >= 13 && seasonOfChoice == "Winter" && environmentType == "Mountains") {
    setScreen("snowyMountainScreen");
  } else {
    setScreen("basicHotelScreen");
  }
}

// Updates the variables (or answers that the user inputs) so that the program correctly displays the best location.
function updateOptions() {
  seasonOfChoice = getText("seasonOfChoice");
  environmentType = getText("environmentType");
  age = getText("age");
}

/* 
Prevents the age variable from being set to an unreasonable value.
(The reason it's set to not go above 123 is because the oldest person to ever live was only 122 years old, fun fact)
*/
function fixAge() {
  /* 
  Converts words (like one, two, three, etc) to the number, 1, 2, 3, etc.
  yea i got really bored here lol
  */
  if (age == "one" || age == "one".toUpperCase()) {
    age = 1;
  } else if (age == "two" || age == "two".toUpperCase()) {
    age = 2;
  } else if (age == "three" || age == "three".toUpperCase()) {
    age = 3;
  } else if (age == "four" || age == "four".toUpperCase()) {
    age = 4;
  } else if (age == "five" || age == "five".toUpperCase()) {
    age = 5;
  } else if (age == "six" || age == "six".toUpperCase()) {
    age = 6;
  } else if (age == "seven" || age == "seven".toUpperCase()) {
    age = 7;
  } else if (age == "eight" || age == "eight".toUpperCase()) {
    age = 8;
  } else if (age == "nine" || age == "nine".toUpperCase()) {
    age = 9;
  } else if (age == "ten" || age == "ten".toUpperCase()) {
    age = 10;
  } else if (age == "eleven" || age == "eleven".toUpperCase()) {
    age = 11;
  } else if (age == "twelve" || age == "twelve".toUpperCase()) {
    age = 12;
  } else if (age == "thirteen" || age == "thirteen".toUpperCase()) {
    age = 13;
  } else if (age == "fourteen" || age == "fourteen".toUpperCase()) {
    age = 14;
  } else if (age == "fifteen" || age == "fifteen".toUpperCase()) {
    age = 15;
  } else if (age == "sixteen" || age == "sixteen".toUpperCase()) {
    age = 16;
  } else if (age == "seventeen" || age == "seventeen".toUpperCase()) {
    age = 17;
  } else if (age == "eighteen" || age == "eighteen".toUpperCase()) {
    age = 18;
  } else if (age == "nineteen" || age == "nineteen".toUpperCase()) {
    age = 19;
  } else if (age == "twenty" || age == "twenty".toUpperCase()) {
    age = 20;
  } else if (age == "thirty" || age == "thirty".toUpperCase()) {
    age = 30;
  } else if (age == "fourty" || age == "fourty".toUpperCase()) {
    age = 40;
  } else if (age == "fifty" || age == "fifty".toUpperCase()) {
    age = 50;
  } else if (age == "sixty" || age == "sixty".toUpperCase()) {
    age = 60;
  } else if (age == "seventy" || age == "seventy".toUpperCase()) {
    age = 70;
  } else if (age == "eighty" || age == "eighty".toUpperCase()) {
    age = 80;
  } else if (age == "ninety" || age == "ninety".toUpperCase()) {
    age = 90;
  }

  if (age < 0 || age >= 123) {
    age = 13;
    setText("age", age);
  }
}

// Gives a random location to the user (using a random number generator) if they are feeling lazy.
function supriseMe() {
var suprise = randomNumber(1, 5);
  if (suprise == 1) {
    setScreen("summerAndBeachScreen");
  } else if (suprise == 2) {
    setScreen("basicHotelScreen");
  } else if (suprise == 3) {
    setScreen("snowyMountainScreen");
  } else if (suprise == 4) {
    setScreen("hotPlaceScreen");
  } else if (suprise == 5) {
    setScreen("parkScreen");
  }
}
/*
END OF VACATION CODE
*/

/*
START MATH GAME CODE
*/
var difficulty; // the difficulty of the game
var firstNumber; // the first number of the equation
var secondNumber; // the second number of the equation
var operator; // the operator (+, -, * or /) of the equation
var equationInput; // the user's answer
var equationAnswer; // the correct answer
var points = 0; // how many points the user has
var score; // the score that the user makes at the end of the game
var winstreak = 1; // the user's winstreak
var name; // the user's name
var questionsAnswered = 0; // the amount of questions that the user got through and answered
var correctlyAnsweredQuestions = 0; // the amount of questions that the user got right
var incorrectlyAnsweredQuestions = 0; // the amount of questions that the user got wrong
var maximumQuestions = 20; // the maximum number of questions the user will answer before the game ends (customizable)
var backgroundImage; // the theme, or background of the screen
var playMusic; // should the game play music or not, based off the music setting
var music; // the music setting
var cheatMode; // allows the user to use the calculator during the game

onEvent("dontClickThisButton", "click", function() {
  setScreen("difficultyScreen");
  playAppSound();
});

onEvent("nextButtonDifficultyScreen", "click", function() {
  difficulty = getText("difficulty");
  setScreen("nameScreen");
  playAppSound();
});

onEvent("backButtonDifficultyScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
});

onEvent("nextButtonNameScreen", "click", function() {
  name = getText("nameInput");
  if (name == "") { // if the user doesn't enter a name, they will be sent to the invalid name screen. if not, then they will proceed to the next screen (theme screen).
    setScreen("invalidNameScreen");
    determineAppSound();
    if (soundOn) {
      playSound("assets/category_retro/retro_game_echo_error_1.mp3");
    }
  } else {
    /*
    if the difficulty is easy or normal, the default maximum number of questions that the user will answer before the game ends will be 20.
    if it's hard, it will be 15.
    if it's hardER, it will be 10.
    impossible, 5.
    */
    if (difficulty == "Easy" || difficulty == "Normal") {
      maximumQuestions = 20;
    } else if (difficulty == "Hard") {
      maximumQuestions = 15;
    } else if (difficulty == "Harder") {
      maximumQuestions = 10;
    } else if (difficulty == "Impossible") {
      maximumQuestions = 5;
    }
    setText("maximumQuestionsAmountLabel", "Amount of Questions: " + maximumQuestions);
    setProperty("maximumQuestionsAmount", "value", maximumQuestions);
    setProperty("beginButton", "hidden", false);
    setProperty("resumeButton", "hidden", true);
    setScreen("themeScreen");
    if (backgroundImage == null) {
      setText("currentThemeLabel", "Current Theme:\nNONE");
    } else if (backgroundImage == 1) {
      setText("currentThemeLabel", "Current Theme:\nGreen Board");
    } else if (backgroundImage == 2) {
      setText("currentThemeLabel", "Current Theme:\nBlue");
    } else if (backgroundImage == 3) {
      setText("currentThemeLabel", "Current Theme:\nWhite Pencil");
    } else if (backgroundImage == 4) {
      setText("currentThemeLabel", "Current Theme:\nBlack Board");
    }
    playAppSound();
  }
});

onEvent("maximumQuestionsAmount", "change", function() {
  maximumQuestions = getNumber("maximumQuestionsAmount");
  setText("maximumQuestionsAmountLabel", "Amount of Questions: " + maximumQuestions);
});

onEvent("backButtonNameScreen", "click", function() {
  setScreen("difficultyScreen");
  playAppSound();
});

onEvent("backButtonInvalidNameScreen", "click", function() {
  setScreen("nameScreen");
  playAppSound();
});

onEvent("backButtonInvalidAgeScreen", "click", function() {
  setScreen("questionScreen");
  playAppSound();
});

onEvent("homeButtonInvalidNameScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
});

// image 1 is the green math board
onEvent("image1", "click", function() {
  backgroundImage = 1;
  setText("currentThemeLabel", "Current Theme:\nGreen Board");
  playAppSound();
});

// image 2 is the cool looking blue background
onEvent("image2", "click", function() {
  backgroundImage = 2;
  setText("currentThemeLabel", "Current Theme:\nBlue");
  playAppSound();
});

// image 3 is the basic math with a pencil
onEvent("image3", "click", function() {
  backgroundImage = 3;
  setText("currentThemeLabel", "Current Theme:\nWhite Pencil");
  playAppSound();
});

// image 4 is the black background
onEvent("image4", "click", function() {
  backgroundImage = 4;
  setText("currentThemeLabel", "Current Theme:\nBlack Board");
  playAppSound();
});

onEvent("beginButton", "click", function() {
  maximumQuestions = getNumber("maximumQuestionsAmount");
  doBackground();
  console.log("Good luck, " + name + "! :)");
  doEquation();
  playGameMusic();
});

onEvent("answerButton", "click", function() {
  determineAppSound();
  clear();
  equationInput = getText("equationInput");
  equationInput = Math.round(equationInput * 10) / 10; // rounds the user's answer to make it fair.
  if (equationInput == "") { // if the user doesn't enter an answer, then they will be told to put in one.
    setProperty("answerError", "hidden", false);
    if (soundOn) {
      playSound("assets/category_retro/retro_game_echo_error_2.mp3");
    }
    console.log("You must enter an answer!");
  } else if (questionsAnswered == (maximumQuestions - 1)) { // if the user has answered the maximum number of questions, then the game will end and the user will be sent to the finished screen.
    if (equationInput == equationAnswer) { // if the user gets the question right
      addPoints();
      questionsAnswered = questionsAnswered + 1;
      correctlyAnsweredQuestions = correctlyAnsweredQuestions + 1;
    } else { // if the user gets the question wrong
      subtractPoints();
      questionsAnswered = questionsAnswered + 1;
      incorrectlyAnsweredQuestions = incorrectlyAnsweredQuestions + 1;
    }
    /*
    Calculates the score and rounds it to remove any unneccesary numbers after the decimal point.
    (Score is calculated by taking the number of questions answered correctly, divided by the maximum number of questions, times 100.)
    */
    score = (correctlyAnsweredQuestions / maximumQuestions) * 100;
    score = Math.round(score * 100) / 100;
      if (score <= 39) {
        setText("finishedLabel", "Oh no...\nBetter luck\nnext time. :(");
        setProperty("scoreLabel", "text-color", rgb(90, 0, 0));
        if (soundOn) {
          playSound("assets/category_music/crackle_loss_1.mp3");
        }
      } else if (score >= 40 && score <= 59) {
        setText("finishedLabel", "Not horrible but,\nnot great either.\nKeep trying, " + name + "!");
        setProperty("scoreLabel", "text-color", "red");
        if (soundOn) {
          playSound("assets/category_music/crackle_loss_1.mp3");
        }
      } else if (score >= 60 && score <= 79) {
        setText("finishedLabel", "You passed,\n" + name + "!");
        setProperty("scoreLabel", "text-color", rgb(255, 240, 30));
        if (soundOn) {
          playSound("assets/category_collect/energy_bar_recharge_2.mp3");
        }
      } else if (score >= 80 && score <= 94) {
        setText("finishedLabel", "Wow! Great job,\n" + name + "!");
        setProperty("scoreLabel", "text-color", rgb(2, 255, 90));
        if (soundOn) {
          playSound("assets/category_collect/energy_bar_recharge_4.mp3");
        }
      } else if (score >= 95) {
        setText("finishedLabel", "You have become a \ngod at math...\nOutstanding job,\n" + name + "!");
        setProperty("scoreLabel", "text-color", rgb(2, 255, 90));
        if (soundOn) {
          playSound("assets/category_achievements/melodic_win_2.mp3");
        }
      }
      setText("scoreLabel", "Score: " + score + "%");
      setText("questionsAnsweredLabel", "Questions Answered: " + questionsAnswered);
      setProperty("correctlyAnsweredQuestionsLabel", "text-color", rgb(2, 255, 90));
      setText("correctlyAnsweredQuestionsLabel", "Questions Answered Correctly: " + correctlyAnsweredQuestions);
      setProperty("incorrectlyAnsweredQuestionsLabel", "text-color", "red");
      setText("incorrectlyAnsweredQuestionsLabel", "Questions Answered Inorrectly: " + incorrectlyAnsweredQuestions);
      setText("pointsLabel", "Points: " + points);
      setText("difficultyLabelFinishedScreen", "Difficulty:\n" + difficulty);
      setScreen("finishedScreen");
      stopGameMusic();
      var pointsLabel;
      if (points == 1) { // fixes a grammar issue, so that the console log doesn't say "1 points", but instead says it correctly, "1 point".
        pointsLabel = "point";
      } else {
        pointsLabel = "points";
      }
      console.log("You finished! You answered " + questionsAnswered + " questions, " + correctlyAnsweredQuestions + " of which were correct, and " + incorrectlyAnsweredQuestions + " were incorrect. You played on " + difficulty.toLowerCase() + " difficulty and made a score of " + score + "% with " + points + " " + pointsLabel + ".");
  } else if (equationInput == equationAnswer) { // if the user gets the question right
    addPoints();
    console.log("Good job! You got it right!");
    determineWinstreakAndPlaySounds();
    console.log("Points: " + points);
    questionsAnswered = questionsAnswered + 1;
    correctlyAnsweredQuestions = correctlyAnsweredQuestions + 1;
    setProperty("answerError", "hidden", true);
    setScreen("correctScreen");
    setText("pointsLabelCorrectScreen", "Points: " + points);
    setText("questionsAnsweredLabelCorrectScreen", "Questions\nAnswered: " + questionsAnswered + "/" + maximumQuestions);
  } else { // if the user gets the question wrong
    subtractPoints();
    questionsAnswered = questionsAnswered + 1;
    incorrectlyAnsweredQuestions = incorrectlyAnsweredQuestions + 1;
    setProperty("answerError", "hidden", true);
    setScreen("incorrectScreen");
    setText("theCorrectAnswerLabel", "The correct answer was\n" + equationAnswer + "\nYou put: " + equationInput);
    setText("pointsLabelIncorrectScreen", "Points: " + points);
    setText("questionsAnsweredIncorrectScreen", "Questions\nAnswered: " + questionsAnswered + "/" + maximumQuestions);
    if (soundOn) {
      playSound("assets/category_alerts/vibrant_wrong_action_hit_1.mp3");
    }
    console.log("Oof! The correct answer was " + equationAnswer + "." + "\nYou put: " + equationInput + "\nPoints: " + points);
  }
});

onEvent("quitButtonEquationScreen", "click", function() {
  stopGameMusic();
  setProperty("answerError", "hidden", true);
  setScreen("homeScreen");
  playAppSound();
  resetStats();
});

onEvent("changeThemeButton", "click", function() {
  shouldGoBackToNameScreen = false;
  setProperty("resumeButton", "hidden", false);
  setProperty("beginButton", "hidden", true);
  setScreen("themeScreen");
  playAppSound();
});

onEvent("resumeButton", "click", function() {
  shouldGoBackToNameScreen = true;
  doBackground();
  setScreen("equationScreen");
  playAppSound();
});

onEvent("calculatorButtonCheatMode", "click", function() {
  setProperty("backButtonCalculatorScreen", "hidden", false);
  // tells the user what their question was in the text box and in debug console.
  setText("equationForCalculatorScreen", "The problem was:\n" + firstNumber + " " + operator + " " + secondNumber);
  console.log("The problem was: " + firstNumber + " " + operator + " " + secondNumber);
  setProperty("equationForCalculatorScreen", "hidden", false);
  setScreen("calculatorScreen");
  playAppSound();
});

onEvent("goAgainButton", "click", function() {
  doBackground();
  doEquation();
});

onEvent("playAgainButtonFinishedScreen", "click", function() {
  setScreen("difficultyScreen");
  playAppSound();
  resetStats();
});

onEvent("tryAgainButton", "click", function() {
  doBackground();
  doEquation();
  playAppSound();
});

onEvent("homeButtonCorrectScreen", "click", function() {
  stopGameMusic();
  setScreen("homeScreen");
  playAppSound();
  resetStats();
});

onEvent("homeButtonIncorrectScreen", "click", function() {
  stopGameMusic();
  setScreen("homeScreen");
  playAppSound();
  resetStats();
});

onEvent("homeButtonFinishedScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
  resetStats();
});

onEvent("backButtonThemeScreen", "click", function() {
  if (shouldGoBackToNameScreen == false) {
    setScreen("equationScreen");
  } else {
    setScreen("nameScreen");
  }
  playAppSound();
});

// The points system, for when you answer a question correctly (it adds points based on the difficulty and equation).
function addPoints() {
  difficulty = getText("difficulty");
  winstreak = winstreak + 1;
  if (difficulty == "Easy" || difficulty == "Normal" || difficulty == "Hard") { // if the difficulty is easy, normal or hard, the user will gain a single point.
    points = points + 1;
  } else if (difficulty == "Harder" || difficulty == "Impossible") {
    if (firstNumber >= 77 && firstNumber <= 999 || secondNumber >= 77 && secondNumber >= 999) { // if the difficulty is harder or impossible, and the question is hard... then the user will gain 2 points.
      points = points + 2;
    } else if (firstNumber >= 1000 || secondNumber >= 1000) { // if the question is extremely difficult, and it's a multiplication/division problem, then the user will gain 5 points.
      if (operator == "*" || operator == "/") {
        points = points + 5;
      } else {
        points = points + 3; // if the question is just addition or subtraction, then the user will gain 3 points.
      }
    }
  }
}

// The points system, for when you answer a question incorrectly (it takes away points based on the difficulty and equation).
function subtractPoints() {
  difficulty = getText("difficulty");
  if (winstreak > 1) {
    console.log("Oh no, " + name + "! You lost your winstreak of " + winstreak + "!");
  }
  winstreak = 0;
  if (difficulty == "Easy" || difficulty == "Normal" || difficulty == "Hard") {// if the difficulty is easy, normal or hard, the user will lose a point.
    points = points - 1;
  } else if (difficulty == "Harder" || difficulty == "Impossible") { // if the difficulty is harder or impossible, and the question is hard... then the user will lose 2 points.
    if (firstNumber >= 77 && firstNumber <= 999 || secondNumber >= 77 && secondNumber >= 999) {
      points = points - 2;
    } else if (firstNumber >= 1000 || secondNumber >= 1000) { // if the question is extremely difficult, and it's a multiplication/division problem, then the user will lose 5 points.
      if (operator == "*" || operator == "/") {
        points = points - 5;
      } else {
        points = points - 3; // if the question is just addition or subtraction, then the user will lose 3 points.
      }
    }
  }
  
  if (points < 0) { // stops the amount of points from going into the negatives.
    points = 0;
  }
}

// Congratulates the user if the winstreak is 3, 10 or 20. If the winstreak does not equal any of those, then the game goes on normally.
function determineWinstreakAndPlaySounds() {
  determineAppSound();
  if (winstreak == 3) {
    setProperty("goodJobLabel", "hidden", false);
    setText("goodJobLabel", "Good job,\n" + name + "!");
    setProperty("winstreakLabel", "hidden", false);
    setText("winstreakLabel", "You are on a winstreak of " + winstreak + "!");
    console.log("Wow, " + name + "! You are on a " + winstreak + " winstreak!");
    if (soundOn) {
      playSound("assets/category_digital/win.mp3");
    }
  } else if (winstreak == 10) {
    setProperty("goodJobLabel", "hidden", false);
    setText("goodJobLabel", "AMAZING job,\n" + name + "!");
    setProperty("winstreakLabel", "hidden", false);
    setText("winstreakLabel", "You are on a winstreak of " + winstreak + "!");
    console.log("Oh my...\n" + name + " is on a " + winstreak + " winstreak! You are insane!");
    if (soundOn) {
      playSound("assets/category_explosion/8bit_explosion.mp3");
    }
  } else if (winstreak == 20) {
    console.log("NICE! You won! Good job " + name + "!");
    if (soundOn) {
      playSound("assets/category_achievements/melodic_win_6.mp3");
    }
  } else if (winstreak != 3 || winstreak != 10 || winstreak != 20) {
    setProperty("goodJobLabel", "hidden", true);
    setProperty("winstreakLabel", "hidden", true);
    if (soundOn) {
      playSound("assets/category_alerts/vibrant_game_correct_answer_hit.mp3");
    }
  }
}

// Resets the stats (such as winstreak, points, questions answered, etc.)
function resetStats() {
  winstreak = 0;
  points = 0;
  score = 0;
  questionsAnswered = 0;
  correctlyAnsweredQuestions = 0;
  incorrectlyAnsweredQuestions = 0;
}

// Selects a song from 4 different options and plays it if the music setting is on while the user plays the game.
function playGameMusic() {
  playMusic = getText("musicOption");
  if (playMusic == "on".toUpperCase()) {
    music = randomNumber(1, 3);
    if (music == 1) {
      playSound("assets/Confluence.mp3", true);
      console.log("Now playing: \"Confluence\" by Secession Studios");
    } else if (music == 2) {
      playSound("assets/The-Ends.mp3", true);
      console.log("Now playing: \"The Ends\" by Luke Howard");
    } else if (music == 3) {
      playSound("assets/Respite.mp3", true);
      console.log("Now playing: \"Respite\" by Goldmund");
    }
  }
}

// Stops all the music.
function stopGameMusic() {
  stopSound("assets/Confluence.mp3");
  stopSound("assets/The-Ends.mp3");
  stopSound("assets/Respite.mp3");
}

// Send the user to the equation screen, in which the program generates the equation (first and second number as well as the operator) and then determines the correct answer.
function doEquation() {
  if (difficulty == "Easy") {
    firstNumber = randomNumber(1, 7);
    secondNumber = randomNumber(1, 7);
  } else if (difficulty == "Normal") {
    firstNumber = randomNumber(3, 9);
    secondNumber = randomNumber(1, 9);
  } else if (difficulty == "Hard") {
    firstNumber = randomNumber(10, 24);
    secondNumber = randomNumber(10, 24);
  } else if (difficulty == "Harder") {
    firstNumber = randomNumber(25, 100);
    secondNumber = randomNumber(25, 100);
  } else if (difficulty == "Impossible") {
    firstNumber = randomNumber(100, 1000);
    secondNumber = randomNumber(100, 1000);
  }
  
  if (difficulty != "Easy") { // so this would mean if the difficulty is Normal or Hard.
    operator = randomNumber(1, 4);
  } else if (difficulty == "Harder" || difficulty == "Impossible") {
    operator = randomNumber(3, 4);
  } else { // if easy difficulty, the only possible operators to get are + and -.
    operator = randomNumber(1, 2);
  }
  
  if (operator == 1) {
    operator = "+";
  } else if (operator == 2) {
    operator = "-";
  } else if (operator == 3) {
    operator = "*";
  } else if (operator == 4) {
    operator = "/";
  }

  var newSecondNumber;
  if (difficulty == "Easy") {
    while (operator == "-" && secondNumber > firstNumber) {
      newSecondNumber = randomNumber(1, 7);
      secondNumber = newSecondNumber;
    }
  } else if (difficulty == "Normal") {
    if (operator == "-") {
      while (secondNumber > firstNumber || secondNumber == firstNumber) {
        newSecondNumber = randomNumber(1, 8);
        secondNumber = newSecondNumber;
      }
    } else if (operator == "/") {
      var allowedNumbers = [1, 2, 4, 8];
      var blockedNumbers = [3, 5, 7, 9];
      if (firstNumber == blockedNumbers[0] || firstNumber == blockedNumbers[1] || firstNumber == blockedNumbers[2] || firstNumber == blockedNumbers[3]) {
        firstNumber = firstNumber - 1;
      }
      
      if (secondNumber == blockedNumbers[0] || secondNumber == blockedNumbers[1] || secondNumber == blockedNumbers[2] || secondNumber == blockedNumbers[3]) {
        secondNumber = secondNumber - 1;
      }
      
      while (secondNumber > firstNumber || secondNumber == firstNumber) {
        newSecondNumber = randomNumber(0, 3);
        secondNumber = allowedNumbers[newSecondNumber];
      }
    }
  }
  
  setText("firstNumberLabel", firstNumber);
  setText("secondNumberLabel", secondNumber);
  setText("operatorLabel", operator);
  
  if (operator == "+") {
    equationAnswer = firstNumber + secondNumber;
  } else if (operator == "-") {
    equationAnswer = firstNumber - secondNumber;
  } else if (operator == "*") {
    equationAnswer = firstNumber * secondNumber;
  } else if (operator == "/") {
    equationAnswer = firstNumber / secondNumber;
  }
  equationAnswer = Math.round(equationAnswer * 10) / 10; // rounds the answer and removes any unneccesary numbers after the decimal point.
  setText("equationInput", "");
  cheatMode = getText("cheatModeOption");
  setProperty("calculatorButtonCheatMode", "hidden", cheatMode == "OFF");
  setScreen("equationScreen");
  setText("difficultyLabelCorrectScreen", "Difficulty:\n " + difficulty);
  setText("difficultyLabelIncorrectScreen", "Difficulty:\n " + difficulty);
}

// Displays the users desired background image. If the user did not select an image, then the program will randomly pick one.
function doBackground() {
  if (backgroundImage == null) {
    backgroundImage = randomNumber(1, 4);
    console.log("You didn't choose a theme, so we're choosing one for you! :)");
  }
  
  // image 1 is the green math background
  if (backgroundImage == 1) {
    /*
    EQUATION SCREEN STUFF
    */
    setProperty("firstNumberLabel", "background-color", "#3F8542");
    setProperty("firstNumberLabel", "border-color", "#54E65A");
    setProperty("firstNumberLabel", "text-color", "#FFFFFF");
    setProperty("secondNumberLabel", "background-color", "#3F8542");
    setProperty("secondNumberLabel", "border-color", "#54E65A");
    setProperty("secondNumberLabel", "text-color", "#FFFFFF");
    setProperty("operatorLabel", "background-color", "#3F8542");
    setProperty("operatorLabel", "border-color", "#54E65A");
    setProperty("operatorLabel", "text-color", "#FFFFFF");
    setProperty("equationInput", "background-color", "#3F8542");
    setProperty("equationInput", "border-color", "#54E65A");
    setProperty("equationInput", "text-color", "#FFFFFF");
    setProperty("answerButton", "background-color", "#3F8542");
    setProperty("answerButton", "border-color", "#54E65A");
    setProperty("answerButton", "text-color", "#FFFFFF");
    setProperty("answerError", "background-color", "#3F8542");
    setProperty("answerError", "border-color", "#54E65A");
    setProperty("answerError", "text-color", "#FFFFFF");
    setProperty("quitButtonEquationScreen", "background-color", "#3F8542");
    setProperty("quitButtonEquationScreen", "border-color", "#54E65A");
    setProperty("quitButtonEquationScreen", "text-color", "#FFFFFF");
    setProperty("changeThemeButton", "background-color", "#3F8542");
    setProperty("changeThemeButton", "border-color", "#54E65A");
    setProperty("changeThemeButton", "text-color", "#FFFFFF");
    setProperty("calculatorButtonCheatMode", "background-color", "#3F8542");
    setProperty("calculatorButtonCheatMode", "border-color", "#54E65A");
    setProperty("equationScreen", "image", "assets/mathematics_image.jpg");
    
    /*
    CORRECT SCREEN STUFF
    */
    setProperty("pointsLabelCorrectScreen", "background-color", "#3F8542");
    setProperty("pointsLabelCorrectScreen", "border-color", "#54E65A");
    setProperty("pointsLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredLabelCorrectScreen", "background-color", "#3F8542");
    setProperty("questionsAnsweredLabelCorrectScreen", "border-color", "#54E65A");
    setProperty("questionsAnsweredLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("correctLabel", "background-color", "#3F8542");
    setProperty("correctLabel", "border-color", "#54E65A");
    setProperty("correctLabel", "text-color", "#FFFFFF");
    setProperty("goodJobLabel", "background-color", "#3F8542");
    setProperty("goodJobLabel", "border-color", "#54E65A");
    setProperty("goodJobLabel", "text-color", "#FFFFFF");
    setProperty("goAgainButton", "background-color", "#3F8542");
    setProperty("goAgainButton", "border-color", "#54E65A");
    setProperty("goAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonCorrectScreen", "background-color", "#3F8542");
    setProperty("homeButtonCorrectScreen", "border-color", "#54E65A");
    setProperty("homeButtonCorrectScreen", "text-color", "#FFFFFF");
    setProperty("winstreakLabel", "background-color", "#3F8542");
    setProperty("winstreakLabel", "border-color", "#54E65A");
    setProperty("winstreakLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelCorrectScreen", "background-color", "#3F8542");
    setProperty("difficultyLabelCorrectScreen", "border-color", "#54E65A");
    setProperty("difficultyLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("correctScreen", "image", "assets/mathematics_image.jpg");
    
    /*
    INCORRECT SCREEN STUFF
    */
    setProperty("pointsLabelIncorrectScreen", "background-color", "#3F8542");
    setProperty("pointsLabelIncorrectScreen", "border-color", "#54E65A");
    setProperty("pointsLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredIncorrectScreen", "background-color", "#3F8542");
    setProperty("questionsAnsweredIncorrectScreen", "border-color", "#54E65A");
    setProperty("questionsAnsweredIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("incorrectLabel", "background-color", "#3F8542");
    setProperty("incorrectLabel", "border-color", "#54E65A");
    setProperty("incorrectLabel", "text-color", "#FFFFFF");
    setProperty("theCorrectAnswerLabel", "background-color", "#3F8542");
    setProperty("theCorrectAnswerLabel", "border-color", "#54E65A");
    setProperty("theCorrectAnswerLabel", "text-color", "#FFFFFF");
    setProperty("tryAgainButton", "background-color", "#3F8542");
    setProperty("tryAgainButton", "border-color", "#54E65A");
    setProperty("tryAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonIncorrectScreen", "background-color", "#3F8542");
    setProperty("homeButtonIncorrectScreen", "border-color", "#54E65A");
    setProperty("homeButtonIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "background-color", "#3F8542");
    setProperty("difficultyLabelIncorrectScreen", "border-color", "#54E65A");
    setProperty("difficultyLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("incorrectScreen", "image", "assets/mathematics_image.jpg");
    
    /*
    FINISHED SCREEN STUFF
    */
    setProperty("finishedLabel", "background-color", "#3F8542");
    setProperty("finishedLabel", "border-color", "#54E65A");
    setProperty("finishedLabel", "text-color", "#FFFFFF");
    setProperty("scoreLabel", "background-color", "#3F8542");
    setProperty("scoreLabel", "border-color", "#54E65A");
    setProperty("questionsAnsweredLabel", "background-color", "#3F8542");
    setProperty("questionsAnsweredLabel", "border-color", "#54E65A");
    setProperty("questionsAnsweredLabel", "text-color", "#FFFFFF");
    setProperty("correctlyAnsweredQuestionsLabel", "background-color", "#3F8542");
    setProperty("correctlyAnsweredQuestionsLabel", "border-color", "#54E65A");
    setProperty("correctlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("incorrectlyAnsweredQuestionsLabel", "background-color", "#3F8542");
    setProperty("incorrectlyAnsweredQuestionsLabel", "border-color", "#54E65A");
    setProperty("incorrectlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("pointsLabel", "background-color", "#3F8542");
    setProperty("pointsLabel", "border-color", "#54E65A");
    setProperty("pointsLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelFinishedScreen", "background-color", "#3F8542");
    setProperty("difficultyLabelFinishedScreen", "border-color", "#54E65A");
    setProperty("difficultyLabelFinishedScreen", "text-color", "#FFFFFF");
    setProperty("homeButtonFinishedScreen", "background-color", "#3F8542");
    setProperty("homeButtonFinishedScreen", "border-color", "#54E65A");
    setProperty("homeButtonFinishedScreen", "text-color", "#FFFFFF");
    setProperty("playAgainButtonFinishedScreen", "background-color", "#3F8542");
    setProperty("playAgainButtonFinishedScreen", "border-color", "#54E65A");
    setProperty("playAgainButtonFinishedScreen", "text-color", "#FFFFFF");
    setProperty("finishedScreen", "image", "assets/mathematics_image.jpg");
  }
  // image 2 is the cool looking blue one
  else if (backgroundImage == 2) {
    /*
    EQUATION SCREEN STUFF
    */
    setProperty("firstNumberLabel", "background-color", "#253A5C");
    setProperty("firstNumberLabel", "border-color", "#8AC1E8");
    setProperty("secondNumberLabel", "background-color", "#253A5C");
    setProperty("secondNumberLabel", "border-color", "#8AC1E8");
    setProperty("operatorLabel", "background-color", "#253A5C");
    setProperty("operatorLabel", "border-color", "#8AC1E8");
    setProperty("equationInput", "background-color", "#253A5C");
    setProperty("equationInput", "border-color", "#8AC1E8");
    setProperty("answerButton", "background-color", "#253A5C");
    setProperty("answerButton", "border-color", "#8AC1E8");
    setProperty("answerError", "background-color", "#253A5C");
    setProperty("answerError", "border-color", "#8AC1E8");
    setProperty("quitButtonEquationScreen", "background-color", "#253A5C");
    setProperty("quitButtonEquationScreen", "border-color", "#8AC1E8");
    setProperty("changeThemeButton", "background-color", "#253A5C");
    setProperty("changeThemeButton", "border-color", "#8AC1E8");
    setProperty("calculatorButtonCheatMode", "background-color", "#253A5C");
    setProperty("calculatorButtonCheatMode", "border-color", "#8AC1E8");
    setProperty("equationScreen", "image", "assets/MIT-MathProblemSolver-01-press.jpg");
    
    /*
    CORRECT SCREEN STUFF
    */
    setProperty("pointsLabelCorrectScreen", "background-color", "#253A5C");
    setProperty("pointsLabelCorrectScreen", "border-color", "#8AC1E8");
    setProperty("questionsAnsweredLabelCorrectScreen", "background-color", "#253A5C");
    setProperty("questionsAnsweredLabelCorrectScreen", "border-color", "#8AC1E8");
    setProperty("correctLabel", "background-color", "#253A5C");
    setProperty("correctLabel", "border-color", "#8AC1E8");
    setProperty("goodJobLabel", "background-color", "#253A5C");
    setProperty("goodJobLabel", "border-color", "#8AC1E8");
    setProperty("goAgainButton", "background-color", "#253A5C");
    setProperty("goAgainButton", "border-color", "#8AC1E8");
    setProperty("homeButtonCorrectScreen", "background-color", "#253A5C");
    setProperty("homeButtonCorrectScreen", "border-color", "#8AC1E8");
    setProperty("winstreakLabel", "background-color", "#253A5C");
    setProperty("winstreakLabel", "border-color", "#8AC1E8");
    setProperty("difficultyLabelCorrectScreen", "background-color", "#253A5C");
    setProperty("difficultyLabelCorrectScreen", "border-color", "#8AC1E8");
    setProperty("correctScreen", "image", "assets/MIT-MathProblemSolver-01-press.jpg");
    
    /*
    INCORRECT SCREEN STUFF
    */
    setProperty("pointsLabelIncorrectScreen", "background-color", "#253A5C");
    setProperty("pointsLabelIncorrectScreen", "border-color", "#8AC1E8");
    setProperty("questionsAnsweredIncorrectScreen", "background-color", "#253A5C");
    setProperty("questionsAnsweredIncorrectScreen", "border-color", "#8AC1E8");
    setProperty("incorrectLabel", "background-color", "#253A5C");
    setProperty("incorrectLabel", "border-color", "#8AC1E8");
    setProperty("theCorrectAnswerLabel", "background-color", "#253A5C");
    setProperty("theCorrectAnswerLabel", "border-color", "#8AC1E8");
    setProperty("tryAgainButton", "background-color", "#253A5C");
    setProperty("tryAgainButton", "border-color", "#8AC1E8");
    setProperty("homeButtonIncorrectScreen", "background-color", "#253A5C");
    setProperty("homeButtonIncorrectScreen", "border-color", "#8AC1E8");
    setProperty("difficultyLabelIncorrectScreen", "background-color", "#253A5C");
    setProperty("difficultyLabelIncorrectScreen", "border-color", "#8AC1E8");
    setProperty("incorrectScreen", "image", "assets/MIT-MathProblemSolver-01-press.jpg");
    
    /*
    FINISHED SCREEN STUFF
    */
    setProperty("finishedLabel", "background-color", "#253A5C");
    setProperty("finishedLabel", "border-color", "#8AC1E8");
    setProperty("scoreLabel", "background-color", "#253A5C");
    setProperty("scoreLabel", "border-color", "#8AC1E8");
    setProperty("questionsAnsweredLabel", "background-color", "#253A5C");
    setProperty("questionsAnsweredLabel", "border-color", "#8AC1E8");
    setProperty("correctlyAnsweredQuestionsLabel", "background-color", "#253A5C");
    setProperty("correctlyAnsweredQuestionsLabel", "border-color", "#8AC1E8");
    setProperty("incorrectlyAnsweredQuestionsLabel", "background-color", "#253A5C");
    setProperty("incorrectlyAnsweredQuestionsLabel", "border-color", "#8AC1E8");
    setProperty("pointsLabel", "background-color", "#253A5C");
    setProperty("pointsLabel", "border-color", "#8AC1E8");
    setProperty("difficultyLabelFinishedScreen", "background-color", "#253A5C");
    setProperty("difficultyLabelFinishedScreen", "border-color", "#8AC1E8");
    setProperty("homeButtonFinishedScreen", "background-color", "#253A5C");
    setProperty("homeButtonFinishedScreen", "border-color", "#8AC1E8");
    setProperty("playAgainButtonFinishedScreen", "background-color", "#253A5C");
    setProperty("playAgainButtonFinishedScreen", "border-color", "#8AC1E8");
    setProperty("finishedScreen", "image", "assets/MIT-MathProblemSolver-01-press.jpg");
    
    /*
    ENSURE TEXT COLOR
    */
    setProperty("firstNumberLabel", "text-color", "#FFFFFF");
    setProperty("secondNumberLabel", "text-color", "#FFFFFF");
    setProperty("operatorLabel", "text-color", "#FFFFFF");
    setProperty("equationInput", "text-color", "#FFFFFF");
    setProperty("answerButton", "text-color", "#FFFFFF");
    setProperty("answerError", "text-color", "#FFFFFF");
    setProperty("quitButtonEquationScreen", "text-color", "#FFFFFF");
    setProperty("changeThemeButton", "text-color", "#FFFFFF");
    setProperty("pointsLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("correctLabel", "text-color", "#FFFFFF");
    setProperty("goodJobLabel", "text-color", "#FFFFFF");
    setProperty("goAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonCorrectScreen", "text-color", "#FFFFFF");
    setProperty("winstreakLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("pointsLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("incorrectLabel", "text-color", "#FFFFFF");
    setProperty("theCorrectAnswerLabel", "text-color", "#FFFFFF");
    setProperty("tryAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("finishedLabel", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredLabel", "text-color", "#FFFFFF");
    setProperty("correctlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("incorrectlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("pointsLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelFinishedScreen", "text-color", "#FFFFFF");
    setProperty("homeButtonFinishedScreen", "text-color", "#FFFFFF");
    setProperty("playAgainButtonFinishedScreen", "text-color", "#FFFFFF");
  }
  // image 3 is the boring white background with the pencil
  else if (backgroundImage == 3) {
    /*
    EQUATION SCREEN STUFF
    */
    setProperty("firstNumberLabel", "background-color", "#FFFFFF");
    setProperty("firstNumberLabel", "border-color", "#000000");
    setProperty("firstNumberLabel", "text-color", "#000000");
    setProperty("secondNumberLabel", "background-color", "#FFFFFF");
    setProperty("secondNumberLabel", "border-color", "#000000");
    setProperty("secondNumberLabel", "text-color", "#000000");
    setProperty("operatorLabel", "background-color", "#FFFFFF");
    setProperty("operatorLabel", "border-color", "#000000");
    setProperty("operatorLabel", "text-color", "#000000");
    setProperty("equationInput", "background-color", "#FFFFFF");
    setProperty("equationInput", "border-color", "#000000");
    setProperty("equationInput", "text-color", "#000000");
    setProperty("answerButton", "background-color", "#FFFFFF");
    setProperty("answerButton", "border-color", "#000000");
    setProperty("answerButton", "text-color", "#000000");
    setProperty("answerError", "background-color", "#FFFFFF");
    setProperty("answerError", "border-color", "#000000");
    setProperty("answerError", "text-color", "#000000");
    setProperty("quitButtonEquationScreen", "background-color", "#FFFFFF");
    setProperty("quitButtonEquationScreen", "border-color", "#000000");
    setProperty("quitButtonEquationScreen", "text-color", "#000000");
    setProperty("changeThemeButton", "background-color", "#FFFFFF");
    setProperty("changeThemeButton", "border-color", "#000000");
    setProperty("changeThemeButton", "text-color", "#000000");
    setProperty("calculatorButtonCheatMode", "background-color", "#FFFFFF");
    setProperty("calculatorButtonCheatMode", "border-color", "#000000");
    setProperty("equationScreen", "image", "assets/iStock-470493341-copy.jpg");
    
    /*
    CORRECT SCREEN STUFF
    */
    setProperty("pointsLabelCorrectScreen", "background-color", "#FFFFFF");
    setProperty("pointsLabelCorrectScreen", "border-color", "#000000");
    setProperty("pointsLabelCorrectScreen", "text-color", "#000000");
    setProperty("questionsAnsweredLabelCorrectScreen", "background-color", "#FFFFFF");
    setProperty("questionsAnsweredLabelCorrectScreen", "border-color", "#000000");
    setProperty("questionsAnsweredLabelCorrectScreen", "text-color", "#000000");
    setProperty("correctLabel", "background-color", "#FFFFFF");
    setProperty("correctLabel", "border-color", "#000000");
    setProperty("correctLabel", "text-color", "#000000");
    setProperty("goodJobLabel", "background-color", "#FFFFFF");
    setProperty("goodJobLabel", "border-color", "#000000");
    setProperty("goodJobLabel", "text-color", "#000000");
    setProperty("goAgainButton", "background-color", "#FFFFFF");
    setProperty("goAgainButton", "border-color", "#000000");
    setProperty("goAgainButton", "text-color", "#000000");
    setProperty("homeButtonCorrectScreen", "background-color", "#FFFFFF");
    setProperty("homeButtonCorrectScreen", "border-color", "#000000");
    setProperty("homeButtonCorrectScreen", "text-color", "#000000");
    setProperty("winstreakLabel", "background-color", "#FFFFFF");
    setProperty("winstreakLabel", "border-color", "#000000");
    setProperty("winstreakLabel", "text-color", "#000000");
    setProperty("difficultyLabelCorrectScreen", "background-color", "#FFFFFF");
    setProperty("difficultyLabelCorrectScreen", "border-color", "#000000");
    setProperty("difficultyLabelCorrectScreen", "text-color", "#000000");
    setProperty("correctScreen", "image", "assets/iStock-470493341-copy.jpg");
    
    /*
    INCORRECT SCREEN STUFF
    */
    setProperty("pointsLabelIncorrectScreen", "background-color", "#FFFFFF");
    setProperty("pointsLabelIncorrectScreen", "border-color", "#000000");
    setProperty("pointsLabelIncorrectScreen", "text-color", "#000000");
    setProperty("questionsAnsweredIncorrectScreen", "background-color", "#FFFFFF");
    setProperty("questionsAnsweredIncorrectScreen", "border-color", "#000000");
    setProperty("questionsAnsweredIncorrectScreen", "text-color", "#000000");
    setProperty("incorrectLabel", "background-color", "#FFFFFF");
    setProperty("incorrectLabel", "border-color", "#000000");
    setProperty("incorrectLabel", "text-color", "#000000");
    setProperty("theCorrectAnswerLabel", "background-color", "#FFFFFF");
    setProperty("theCorrectAnswerLabel", "border-color", "#000000");
    setProperty("theCorrectAnswerLabel", "text-color", "#000000");
    setProperty("tryAgainButton", "background-color", "#FFFFFF");
    setProperty("tryAgainButton", "border-color", "#000000");
    setProperty("tryAgainButton", "text-color", "#000000");
    setProperty("homeButtonIncorrectScreen", "background-color", "#FFFFFF");
    setProperty("homeButtonIncorrectScreen", "border-color", "#000000");
    setProperty("homeButtonIncorrectScreen", "text-color", "#000000");
    setProperty("difficultyLabelIncorrectScreen", "background-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "border-color", "#000000");
    setProperty("difficultyLabelIncorrectScreen", "text-color", "#000000");
    setProperty("incorrectScreen", "image", "assets/iStock-470493341-copy.jpg");
    
    /*
    FINISHED SCREEN STUFF
    */
    setProperty("finishedLabel", "background-color", "#FFFFFF");
    setProperty("finishedLabel", "border-color", "#000000");
    setProperty("finishedLabel", "text-color", "#000000");
    setProperty("scoreLabel", "background-color", "#FFFFFF");
    setProperty("scoreLabel", "border-color", "#000000");
    setProperty("questionsAnsweredLabel", "background-color", "#FFFFFF");
    setProperty("questionsAnsweredLabel", "border-color", "#000000");
    setProperty("questionsAnsweredLabel", "text-color", "#000000");
    setProperty("correctlyAnsweredQuestionsLabel", "background-color", "#FFFFFF");
    setProperty("correctlyAnsweredQuestionsLabel", "border-color", "#000000");
    setProperty("correctlyAnsweredQuestionsLabel", "text-color", "#000000");
    setProperty("incorrectlyAnsweredQuestionsLabel", "background-color", "#FFFFFF");
    setProperty("incorrectlyAnsweredQuestionsLabel", "border-color", "#000000");
    setProperty("incorrectlyAnsweredQuestionsLabel", "text-color", "#000000");
    setProperty("pointsLabel", "background-color", "#FFFFFF");
    setProperty("pointsLabel", "border-color", "#000000");
    setProperty("pointsLabel", "text-color", "#000000");
    setProperty("difficultyLabelFinishedScreen", "background-color", "#FFFFFF");
    setProperty("difficultyLabelFinishedScreen", "border-color", "#000000");
    setProperty("difficultyLabelFinishedScreen", "text-color", "#000000");
    setProperty("homeButtonFinishedScreen", "background-color", "#FFFFFF");
    setProperty("homeButtonFinishedScreen", "border-color", "#000000");
    setProperty("homeButtonFinishedScreen", "text-color", "#000000");
    setProperty("playAgainButtonFinishedScreen", "background-color", "#FFFFFF");
    setProperty("playAgainButtonFinishedScreen", "border-color", "#000000");
    setProperty("playAgainButtonFinishedScreen", "text-color", "#000000");
    setProperty("finishedScreen", "image", "assets/iStock-470493341-copy.jpg");
  }
  // image 4 is the black chalkboard background
  else if (backgroundImage == 4) {
    /*
    EQUATION SCREEN STUFF
    */
    setProperty("firstNumberLabel", "background-color", "#000000");
    setProperty("firstNumberLabel", "border-color", "#FFFFFF");
    setProperty("secondNumberLabel", "background-color", "#000000");
    setProperty("secondNumberLabel", "border-color", "#FFFFFF");
    setProperty("operatorLabel", "background-color", "#000000");
    setProperty("operatorLabel", "border-color", "#FFFFFF");
    setProperty("equationInput", "background-color", "#000000");
    setProperty("equationInput", "border-color", "#FFFFFF");
    setProperty("answerButton", "background-color", "#000000");
    setProperty("answerButton", "border-color", "#FFFFFF");
    setProperty("answerError", "background-color", "#000000");
    setProperty("answerError", "border-color", "#FFFFFF");
    setProperty("quitButtonEquationScreen", "background-color", "#000000");
    setProperty("quitButtonEquationScreen", "border-color", "#FFFFFF");
    setProperty("changeThemeButton", "background-color", "#000000");
    setProperty("changeThemeButton", "border-color", "#FFFFFF");
    setProperty("calculatorButtonCheatMode", "background-color", "#000000");
    setProperty("calculatorButtonCheatMode", "border-color", "#FFFFFF");
    setProperty("equationScreen", "image", "assets/Mathematics-Hero-1600x900.jpg");
    
    /*
    CORRECT SCREEN STUFF
    */
    setProperty("pointsLabelCorrectScreen", "background-color", "#000000");
    setProperty("pointsLabelCorrectScreen", "border-color", "#FFFFFF");
    setProperty("questionsAnsweredLabelCorrectScreen", "background-color", "#000000");
    setProperty("questionsAnsweredLabelCorrectScreen", "border-color", "#FFFFFF");
    setProperty("correctLabel", "background-color", "#000000");
    setProperty("correctLabel", "border-color", "#FFFFFF");
    setProperty("goodJobLabel", "background-color", "#000000");
    setProperty("goodJobLabel", "border-color", "#FFFFFF");
    setProperty("goAgainButton", "background-color", "#000000");
    setProperty("goAgainButton", "border-color", "#FFFFFF");
    setProperty("homeButtonCorrectScreen", "background-color", "#000000");
    setProperty("homeButtonCorrectScreen", "border-color", "#FFFFFF");
    setProperty("winstreakLabel", "background-color", "#000000");
    setProperty("winstreakLabel", "border-color", "#FFFFFF");
    setProperty("difficultyLabelCorrectScreen", "background-color", "#000000");
    setProperty("difficultyLabelCorrectScreen", "border-color", "#FFFFFF");
    setProperty("correctScreen", "image", "assets/Mathematics-Hero-1600x900.jpg");
    
    /*
    INCORRECT SCREEN STUFF
    */
    setProperty("pointsLabelIncorrectScreen", "background-color", "#000000");
    setProperty("pointsLabelIncorrectScreen", "border-color", "#FFFFFF");
    setProperty("questionsAnsweredIncorrectScreen", "background-color", "#000000");
    setProperty("questionsAnsweredIncorrectScreen", "border-color", "#FFFFFF");
    setProperty("incorrectLabel", "background-color", "#000000");
    setProperty("incorrectLabel", "border-color", "#FFFFFF");
    setProperty("theCorrectAnswerLabel", "background-color", "#000000");
    setProperty("theCorrectAnswerLabel", "border-color", "#FFFFFF");
    setProperty("tryAgainButton", "background-color", "#000000");
    setProperty("tryAgainButton", "border-color", "#FFFFFF");
    setProperty("homeButtonIncorrectScreen", "background-color", "#000000");
    setProperty("homeButtonIncorrectScreen", "border-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "background-color", "#000000");
    setProperty("difficultyLabelIncorrectScreen", "border-color", "#FFFFFF");
    setProperty("incorrectScreen", "image", "assets/Mathematics-Hero-1600x900.jpg");
    
    /*
    FINISHED SCREEN STUFF
    */
    setProperty("finishedLabel", "background-color", "#000000");
    setProperty("finishedLabel", "border-color", "#FFFFFF");
    setProperty("scoreLabel", "background-color", "#000000");
    setProperty("scoreLabel", "border-color", "#FFFFFF");
    setProperty("questionsAnsweredLabel", "background-color", "#000000");
    setProperty("questionsAnsweredLabel", "border-color", "#FFFFFF");
    setProperty("correctlyAnsweredQuestionsLabel", "background-color", "#000000");
    setProperty("correctlyAnsweredQuestionsLabel", "border-color", "#FFFFFF");
    setProperty("incorrectlyAnsweredQuestionsLabel", "background-color", "#000000");
    setProperty("incorrectlyAnsweredQuestionsLabel", "border-color", "#FFFFFF");
    setProperty("pointsLabel", "background-color", "#000000");
    setProperty("pointsLabel", "border-color", "#FFFFFF");
    setProperty("difficultyLabelFinishedScreen", "background-color", "#000000");
    setProperty("difficultyLabelFinishedScreen", "border-color", "#FFFFFF");
    setProperty("homeButtonFinishedScreen", "background-color", "#000000");
    setProperty("homeButtonFinishedScreen", "border-color", "#FFFFFF");
    setProperty("playAgainButtonFinishedScreen", "background-color", "#000000");
    setProperty("playAgainButtonFinishedScreen", "border-color", "#FFFFFF");
    setProperty("finishedScreen", "image", "assets/Mathematics-Hero-1600x900.jpg");
    
    /*
    ENSURE TEXT COLOR
    */
    setProperty("firstNumberLabel", "text-color", "#FFFFFF");
    setProperty("secondNumberLabel", "text-color", "#FFFFFF");
    setProperty("operatorLabel", "text-color", "#FFFFFF");
    setProperty("equationInput", "text-color", "#FFFFFF");
    setProperty("answerButton", "text-color", "#FFFFFF");
    setProperty("answerError", "text-color", "#FFFFFF");
    setProperty("quitButtonEquationScreen", "text-color", "#FFFFFF");
    setProperty("changeThemeButton", "text-color", "#FFFFFF");
    setProperty("pointsLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("correctLabel", "text-color", "#FFFFFF");
    setProperty("goodJobLabel", "text-color", "#FFFFFF");
    setProperty("goAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonCorrectScreen", "text-color", "#FFFFFF");
    setProperty("winstreakLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelCorrectScreen", "text-color", "#FFFFFF");
    setProperty("pointsLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("incorrectLabel", "text-color", "#FFFFFF");
    setProperty("theCorrectAnswerLabel", "text-color", "#FFFFFF");
    setProperty("tryAgainButton", "text-color", "#FFFFFF");
    setProperty("homeButtonIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("difficultyLabelIncorrectScreen", "text-color", "#FFFFFF");
    setProperty("finishedLabel", "text-color", "#FFFFFF");
    setProperty("questionsAnsweredLabel", "text-color", "#FFFFFF");
    setProperty("correctlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("incorrectlyAnsweredQuestionsLabel", "text-color", "#FFFFFF");
    setProperty("pointsLabel", "text-color", "#FFFFFF");
    setProperty("difficultyLabelFinishedScreen", "text-color", "#FFFFFF");
    setProperty("homeButtonFinishedScreen", "text-color", "#FFFFFF");
    setProperty("playAgainButtonFinishedScreen", "text-color", "#FFFFFF");
  }
}
/*
END OF MATH GAME CODE
*/

/*
START OF CALCULATOR CODE
*/
var firstNumberInput; // the number that the user enters on the left side
var secondNumberInput; // the number that the user enters on the right side
var calculatorOperator; // the operator that the user chooses (+, -, * or /)
var rawCalculatorResult; // the RAW (or unrounded) value of the correct answer
var calculatorResult; // the correct answer (rounded)
var calculatorAnswer; // the correct answer (as text)

onEvent("calculatorButton", "click", function() {
  setProperty("backButtonCalculatorScreen", "hidden", true);
  setText("equationForCalculatorScreen", "");
  setProperty("equationForCalculatorScreen", "hidden", true);
  setScreen("calculatorScreen");
  playAppSound();
});

onEvent("equalsButton", "click", function() {
  defineVariablesAsText();
  if (firstNumberInput == "" || secondNumberInput == "") { // if one or both of the boxes are blank, the program will tell the user to enter the numbers.
    setProperty("calculatorAnswer", "font-size", 13);
    setText("calculatorAnswer", "You must enter a number into both of the boxes!");
    console.log("You must enter a number into both of the boxes!");
  } else { // if the user did everything correctly, then the program will calculate the user's desired equation
    calculate();
  }
  playAppSound();
});

onEvent("clearButton", "click", function() {
  determineAppSound();
  defineVariablesAsText();
  if (firstNumberInput == "" && secondNumberInput == "" && calculatorOperator == "+" && calculatorAnswer == "") { // if everything is on default settings, then the calculator will have nothing to clear.
    if (soundOn) {
      playSound("assets/category_retro/retro_game_echo_error_2.mp3");
    }
    console.log("There's nothing to clear... o_0");
  } else {
    clear();
    if (soundOn) {
      playSound("assets/category_retro/retro_game_click.mp3");
    }
    console.log("Cleared the calculator.");
  }
});

onEvent("homeButtonCalculatorScreen", "click", function() {
  setScreen("homeScreen");
  playAppSound();
});

onEvent("backButtonCalculatorScreen", "click", function() {
  setScreen("equationScreen");
  clear();
  playAppSound();
});

// Clears the calculator
function clear() {
  setText("firstNumberInput", "");
  setText("secondNumberInput", "");
  setText("calculatorOperator", "+");
  setText("calculatorAnswer", "");
}

// Gets the two numbers (and the operator) that the user inputs when equals is pressed as numbers.
function defineVariablesAsNumbers() {
  firstNumberInput = getNumber("firstNumberInput");
  secondNumberInput = getNumber("secondNumberInput");
  calculatorOperator = getText("calculatorOperator");
}

// Gets the two numbers (and the operator) that the user inputs when equals is pressed as plain text.
function defineVariablesAsText() {
  firstNumberInput = getText("firstNumberInput");
  secondNumberInput = getText("secondNumberInput");
  calculatorOperator = getText("calculatorOperator");
  calculatorAnswer = getText("calculatorAnswer");
}

// Calculates the equation the user inputs.
function calculate() {
  defineVariablesAsNumbers();
  
  if (calculatorOperator == "+") {
    calculatorResult = firstNumberInput + secondNumberInput;
  } else if (calculatorOperator == "-") {
    calculatorResult = firstNumberInput - secondNumberInput;
  } else if (calculatorOperator == "x") {
    calculatorResult = firstNumberInput * secondNumberInput;
  } else if (calculatorOperator == "÷") {
    calculatorResult = firstNumberInput / secondNumberInput;
  }
  
  /*
  my friend wanted me to add this so i did lol
  */
  defineVariablesAsText();
  if (firstNumberInput == "E" && secondNumberInput == "E" && calculatorOperator == "+") {
    calculatorResult = "EEEEE!!!";
  } else {
    rawCalculatorResult = calculatorResult;
    calculatorResult = Math.round(calculatorResult * 100) / 100; // rounds the result and fixes big decimal numbers.
  }
  setProperty("calculatorAnswer", "font-size", 24);
  setText("calculatorAnswer", calculatorResult);
  if (rawCalculatorResult == null) {
    rawCalculatorResult = "blank";
  }
  console.log(firstNumberInput + " " + calculatorOperator + " " + secondNumberInput + " is equal to " + calculatorResult + " (RAW value = " + rawCalculatorResult + ").");
}
/*
END OF CALCULATOR CODE
*/

// Plays the basic app clicking sound, only if the sound option is on.
function playAppSound() {
  sound = getText("soundOption");
  if (sound == "ON") {
    playSound("assets/category_app/app_button_1.mp3");
  }
}

// Gets the current state of the sound setting.
function determineAppSound() {
  sound = getText("soundOption");
  soundOn = getText("soundOption") == "ON";
}

/*
SETTINGS SIDE OF THE APP
*/
onEvent("resetAppButton", "click", function() {
  resetButtonTimesClicked = resetButtonTimesClicked + 1;
  // Resets the apps settings if the button is clicked twice.
  if (resetButtonTimesClicked > 1) {
    setText("musicOption", "OFF");
    setText("soundOption", "ON");
    setText("cheatModeOption", "OFF");
    setText("seasonOfChoice", "Summer");
    setText("environmentType", "Beach");
    setText("age", "13");
    setText("difficulty", "Easy");
    setText("nameInput", "");
    
    playSound("assets/category_app/app_button_1.mp3");
    setProperty("resetAppConfirmationLabel", "font-size", 15);
    setText("resetAppConfirmationLabel", "Reset the app to it's default settings.");
    console.log("Reset the app to it's default settings.");
    resetButtonTimesClicked = 0;
  } else { // Once the button is clicked for the first time, a user will be sent to the user, asking for confirmation.
    playAppSound();
    setProperty("resetAppConfirmationLabel", "font-size", 11);
    setText("resetAppConfirmationLabel", "Are you sure you want to reset the app to it's default settings? Press again to confirm.");
    setProperty("resetAppConfirmationLabel", "hidden", false);
    console.log("Are you sure you want to reset the app to it's default settings? Press again to confirm.");
  }
});

/* 
hi you reached the end :D
all work belongs to DILLON
*/