# Programming Assignment 7 In the respective order, these classes are able to:
BaseResponse Class:<br >
	- has responseCode and responseString variables inherited by StudentResponseString and StudentResponseObject subclasses <br >
	- Used by Controller class to indicate success or failure of method. <br >
StudentResponseString Class: <br >
	- Used by Controller when getting Student as a string<br >
	- content and listContent String variables contain one or many students in their toString() form<br >
StudentResponseObject Class:<br >
	- Used by Controller when getting Student as an object<br >
	- content and listContent String variables contain one or many students as a Student Object. listContent is an ArrayList of Student objects.<br >
Controller Class:<br >
	- The utmost layer of the layered architecture web server<br >
	- Responsible for checking validity of inputs for the methods. (Methods return IResponse with responseCode and responseString
	  representative of the outcome)<br >
	- Methods include getStudent(),getAllStudent(),removeStudent(),addStudent(),updateStudent(),getResponse(),setResponse(),setService(), and getService()
Service Class:<br >
	- Receives requests from the Controller class and relays it to the Database class. Will then receive a message from the Database class and relay<br >
	  it to the Controller Class.
	- The middle layer of the layered architecture web server<br >
	- In addition to the methods in the Controller class relating to Students, may instantiate Database Objects.<br >
	- Contains the studList List<Student> that loads the information from the Database.<br >
Database Class:<br >
	- The bottom later of the layered architecture web server and contains the data of the Student Objects.<br >
	- Will save changed information to the Database file whenever changes are made.<br >
	- Will keep track of the time at which changes are made so that the Database file does not have to be reloaded after each method.<br >
## Author<br >

* **Suk Chan Lee**
- [cs11wme](mailto:scl002@ucsd.edu)


## Acknowledgments

* A thank you to freeCodeCamp and Professor James Gappy who taught me Java.
Gratitudes to Professor Zaitsev who is currently teaching me Java as well.
