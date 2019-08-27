<a name="top"></a>
# Code Fellowship

### Table of Contents
* [Run](#run)
* [Resources](#resources)
* [Files](#files)
* [Methods](#methods)

<a name="run"></a>
### How to Run
* Open terminal and cd into the codefellowship directory
* Enter: `./gradlew bootRun`
* Open web browser to: `localhost:8080`

<a name="resources"></a>
### Resources
* [Bootstrap Form](https://getbootstrap.com/docs/4.3/components/forms/)
* [Bootstrap Nav Bar](https://getbootstrap.com/docs/4.3/components/navbar/#nav)
* Jack Kinne
* Fabian Brooks
* Travis Cox
* Matt Stuhring
* Melfi Perez
* Marisha Hoza

<a name="files"></a>
### Files
* src/main
  * /java
    * [CodefellowshipApplication](./src/main/java/com/nparo/codefellowship/CodefellowshipApplication.java)
  * /java/config
    * [UserDetailsServiceImpl](./src/main/java/com/nparo/codefellowship/config/UserDetailsServiceImpl.java)
    * [WebSecurityConfig](./src/main/java/com/nparo/codefellowship/config/WebSecurityConfig.java)
  * /java/controllers
    * [ApplicationUserController](./src/main/java/com/nparo/codefellowship/controllers/ApplicationUserController.java)
    * [HomeController](./src/main/java/com/nparo/codefellowship/controllers/HomeController.java)
  * /java/models
    * [ApplicationUser](./src/main/java/com/nparo/codefellowship/models/ApplicationUser.java)
    * [ApplicationUserRepository](./src/main/java/com/nparo/codefellowship/models/ApplicationUserRepository.java)
  * /resources/templates
    * [error.html](./src/main/resources/templates/error.html)
    * [index.html](./src/main/resources/templates/index.html)
    * [loginpage.html](./src/main/resources/templates/loginpage.html)
    * [signup.html](./src/main/resources/templates/signup.html)
* src/test
  * /java
    * [CodefellowshipApplicationTests.java](./src/test/java/com/nparo/codefellowship/CodefellowshipApplicationTests.java)
  

<a name="methods"></a>
### Methods
* `ApplicationUserController`
  * `@PostMapping("/users") public RedirectView createUser(String username, String password, String firstName, String lastName,String dateOfBirth, String bio)`
  * `@GetMapping("login") public String getLoginPage()`
  * `@GetMapping("/myprofile") public String getMyProfile(Principal p, Model m)`
  * `@GetMapping("/users") public String getAllUsers(Principal p, Model m)`
  * `@GetMapping("/users/{id}") public String getOneUser(@PathVariable long id, Principal p, Model m)`
* `HomeController`
  * `@GetMapping("/") public String getIndex(Model m)`
  * `@GetMapping("/loginpage") public String getLogin()`
  * `@GetMapping("/signup") public String getSignUp()`

**[Back to Top](#top)**
