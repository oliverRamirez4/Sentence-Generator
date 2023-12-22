The sentence generator is a project I did in Computer Science 2. We were given a bunch of files containing english texts and had to create 
a program that generated sentences using the training data. In my implementation I made a hash map that had the word as a key and a hashmap 
as the value. From there each hash map value contained all the words that followed that word in the training data and the program would put 
the next word in the sentence based on the frequency of the word that followed it in the training data. If the word was "blue" and "ocean"
followed it 3 times in the training data while "sky" followed it one time, there would be a 75% chance that the program put ocean as the
next word and a 25% chance that "sky" was the next word. It finished the sentence once there was a period that came up as the next word/
punctuation to be put in the sentence.
