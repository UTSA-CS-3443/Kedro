# How to run Kedro
- 1.) Download the necessary libraries from this google drive https://drive.google.com/open?id=1wSePjC9E8SG1Ai-y2vomHtWbmrd5YHeF
- 2.) Save the libraries in a folder you can access from eclipse
- 3.) Clone the repo and choose the test branch and then import as an existing project. Make sure you do not clone the master branch at all. There's an issue with cloning it so just ignore it
- 4.) Right click on the project after cloning and click on buildpath and then configure build path
- 5.) Then click on add external jars and browse to where the libraries are saved and add them
- 6.) Next will be to add the license which will be in the folder that the project is saved in.
Navigate here and find 2 files named jxmaps-1.3.1.jar and license.jar. File path from local git
 repo is \git\Kedro\jxmaps-1.3.1.jar and \git\Kedro\license.jar
- 7.) Add them to the list by selecting them and pressing open. The red ! should be gone off
 the project now
- 8.) You can now run the program. Do not reorganize the file system or add files in manually
 or they won't be recognized
- Notes: we couldn't get the controller to use fxml documents in the view package so we had to
 keep them in the controller package. Email any one of us if you have issues or questions
