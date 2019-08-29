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
* [Bootstrap Card](https://getbootstrap.com/docs/4.3/components/card/)
* [Bootstrap Card Sizing](https://getbootstrap.com/docs/4.3/components/card/#sizing)
* [Inline Border](https://developer.mozilla.org/en-US/docs/Web/CSS/border-inline-style)
* [Timestamp Format](https://stackoverflow.com/questions/35170620/format-java-sql-timestamp-into-a-string/35170693)
* [SQL Column Definition](https://docs.oracle.com/javaee/5/api/javax/persistence/Column.html#columnDefinition())
* [Thymeleaf Fragment](https://www.baeldung.com/spring-thymeleaf-fragments)
* [Thymeleaf Empty List Check](https://stackoverflow.com/questions/33106391/how-to-check-if-list-is-empty-using-thymeleaf)
* Jack Kinne
* Fabian Brooks
* Travis Cox
* Matt Stuhring
* Melfi Perez
* Renee Messick
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
    * [PostController](./src/main/java/com/nparo/codefellowship/controllers/PostController.java)
  * /java/models
    * [ApplicationUser](./src/main/java/com/nparo/codefellowship/models/ApplicationUser.java)
    * [ApplicationUserRepository](./src/main/java/com/nparo/codefellowship/models/ApplicationUserRepository.java)
    * [Post](./src/main/java/com/nparo/codefellowship/models/Post.java)
    * [PostRepository](./src/main/java/com/nparo/codefellowship/models/PostRepository.java)
  * /resources
    * /templates/fragments
      * [nav](./src/main/resources/templates/fragments/nav.html)
      * [posts](./src/main/resources/templates/fragments/posts.html)
      * [userInfo](./src/main/resources/templates/fragments/userInfo.html)
    * /templates
      * [error](./src/main/resources/templates/error.html)
      * [feed](./src/main/resources/templates/feed.html)
      * [index](./src/main/resources/templates/index.html)
      * [login](./src/main/resources/templates/login.html)
      * [myprofile](./src/main/resources/templates/myprofile.html)
      * [post](./src/main/resources/templates/post.html)
      * [signup](./src/main/resources/templates/signup.html)
      * [singleUser](./src/main/resources/templates/singleUser.html)
      * [users](./src/main/resources/templates/users.html)
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
  * `@PostMapping("/users/follow") public RedirectView addFollower(long followedUser, Principal p)`
  * `@PostMapping("/users/unfollow") public RedirectView removeFollower(long unfollowedUser, Principal p)`
* `HomeController`
  * `@GetMapping("/") public String getIndex(Model m)`
  * `@GetMapping("/loginpage") public String getLogin()`
  * `@GetMapping("/signup") public String getSignUp()`
* `PostController`
  * `@GetMapping("/post") public String getPost(Principal p, Model m)`
  * `@PostMapping("/post") public RedirectView createPost(String body, Principal p)`

**[Back to Top](#top)**
