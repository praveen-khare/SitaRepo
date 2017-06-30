# IntegrationTask

## Task Detail: 
Input files placed into the directory (C:/SITA_TEST/IN) with a number on each line. Files may be valid or invalid(if other than number occurs in file)
IntegrationTask working is as below 
1. Pick files from input folder(C:/SITA_TEST/IN) and validate it.
2. Open the valid file and sum all the numbers in file and make an .OUTPUT file in directory(C:/SITA_TEST/OUTPUT).
3. After this processed input file will be copy with extension .PROCESSED in directory(C:/SITA_TEST/PROCESSED).
4. Input files those have .txt extension only be picked. 
5. If any invalid file find, the input file will go in directory(C:/SITA_TEST/ERROR) with changed extension .ERROR.
6. All the input files after processing should not exist in the input directory.

## To build the application
1. From the command prompt go to project folder and run command mvn clean install.


## Testing the application.
1. Before running the application, place the input files in the input directory configured under application.properties.
2. Deploy the war IntegrationTask.war and it will automatically start the processing from input folder.

