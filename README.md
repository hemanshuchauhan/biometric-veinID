# Biometric Authentication system – Vein Id based

## Overview

- The vein id authentication is less prone to the security issues as it deals with the vein pattern of an individual and the blood flow in the veins. The vein pattern cannot be faked using any tool compared to with other authentication systems such as hand geometry and finger prints. Vein system being hidden under layers of flesh and being harder to alter provides the competitive advantage. 

- A binary image representing the vein pattern of an individual can be extracted by using a beam of near infrared LED along with a monochromatic camera. 

- The application simulates an authentication system based on a vein pattern by using files each containing vein pattern simulations of users. Each vein pattern is assumed to be matrix of 10x10 in the application.

## Installation 

Build the source using Java. 

## Process 

The process comprise of few matching steps which will compare the input file with the files contained in the system. 

### Basic matching
  The image will be matched for one to one mapping, each bit at each point. The score is based on the matching percentage bits with the total number of bits used in the system images(100 bits) 

### Shift matching 
  The image will be shifted in both directions and is checked for one to one mapping. Here the shift factor indicates the number of bits ( or pixels ) the image has been moved along with the matched image. The shift factor provides the shifting corresponding to the maximum percentage match with the files in the system. 

### Fade match 
  Both images will be faded with black segments ( Vein sizes are widened), and the percentage overlapping is calculated. The score will be higher if the match is a twisted match.

### Fade line match
  Here the black lines in the system images are widened ( Faded )  and the percentage of input image lines being inside the faded lines are calculated. Similar to faded match, the faded line match will generate a higher score if the lines are in the form of twisted manner. 

### Calculation of Confidence level

  - The criteria for confidence level calculation is the percentage score at each stage.

  - If the basic match is 100%, the confidence level will be 100%. 

  - In other cases, following formula is applied

    confidence =(basic_score + 0.5  * (10 – shift_factor) shift_score + 0.3 * faded_score + 0.2 * faded_line_score) / 2.0
    
   -The formula will be more biased toward less shifted, vein ids with low offsets ( or distortions)

## Data storage

- The data is stored in a file based storage in the data directory of the application. 

- user-registry.data file contains the list of users of the application. 

- For each user, there will be a <username>.data file in the same directory containing the vein id of the user. 


## Source 

https://github.com/mahanama94/biometric-veinID
