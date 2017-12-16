# Course project Random Java Program Generator

### Overview
The project creates a syntactically correct but semantically meaningless Java application. The input to our main program
is a configuration file that defines various parameters that constrain the generation of a Java application (e.g., the 
number of lines of code and the number of classes).
Once the constrains are identified the program parses a grammar file that is the crux of random code generation.

We have used a BNF grammar format for the grammar file as shown below;
 
```
<expression>:=<access_type> <var> = <exp> <op> <exp>
<op>:=+ | - | *
<exp>:=<exp> <op> <exp> | <digit>
<class_name>:=<access_modifier> 'class' <class_name> '{' <expression> <class_method> '}'
<inheritence>:=<access_modifier> 'class' <class_name> 'implements' <previous_interface_name> '{' <interface_methods> <class_method> '}'
<class_method>:=<access_modifier> 'void' <method_name> '(' ')' '{' <for_loop> <expression> '}'
```

The program parses the grammar file: "src/resources/grammar.txt" and defines two levels;
1. Top-Level: These rules refer to various class and interface declarations
2. Low-Level: These refer to various programming constructs such as methods, loops, expressions etc.

Each generated java file contains atleast one element from high-level and multiple elements from the low-level, for which 
the bounds are specified in the configuration file.

The configuration file (src/main/resources/config.xml) serves the purpose of defining the bounds for various high and low level elements.

The flow of our application is as below;

 ![image](etc/flow_chart.PNG)

## Setup for project
1. Clone the project from `https://akshayv22@bitbucket.org/sylvestersavioraj/akshay_vedpathak_mohammed_noman_mulla_rohit_vibhu_channananjun.git`
2. Import the project in Intellij 
3. Run gradle and SBT build by running the following commands;
- Gradle Build: 

## Logistics
You can work in groups on this project, however, a student cannot be involved in more than one group. If you want to work alone, it is perfectly fine, however, you can decide to work in a group with up to three more of your classmates. Logistically, one of team members will create a private fork and will invite one or two of her classmates with the write access to your fork. You should be careful who you partner with - once you form a group and write and submit code, you cannot start dividing your work and claim you did most of the work. Your forkmates may turn out to be freeloaders and you will be screwed, but it is a part of your life experience. Be very careful and make sure that you trust your classmates before forming your group. Neither your TA not I can and will resolve your internal group conflicts, unless you can present convincing evidence that you did all the work alone. Your submission will include the names of all of your forkmates and you will receive the same grade for this project. Working in a group will be an excellent opportunity for you to explore branching in git, merging, rebasing, and resolving semantic conflicts when merging your code changes. Don't pass on this opportunity!

If you submitted your previous homework, it means that you were already added as a member of CS_474_2017 team in Bitbucket. Separate repositories will be created for each of your homeworks and for the course project. You will find a corresponding entry for this project. You will fork this repository and your fork will be private, no one else besides you, your forkmates, the TA and your course instructor will have access to your fork. Please remember to grant a read access to your repository to your TA and your instructor and write access to your forkmates. You can commit and push your code as many times as you want. Your code will not be visible and it should not be visible to other students except for your forkmate, of course. When you push your project, your instructor and the TA will see you code in your separate private fork. Making your fork public or inviting other students except for your forkmates to join your fork will result in losing your grade. For grading, only the latest push timed before the deadline will be considered. If you push after the deadline, your grade for the homework will be zero. For more information about using git and bitbucket specifically, please use this link as the starting point https://confluence.atlassian.com/bitbucket/bitbucket-cloud-documentation-home-221448814.html. For those of you who still struggle with Git, I keep recommending a book by Ryan Hodson on Ry's Git Tutorial. The other book called Pro Git is written by Scott Chacon and Ben Straub and published by Apress and it is freely available https://git-scm.com/book/en/v2/. There are multiple videos on youtube that go into details of Git organization and use.

As your TA specified, please follow this naming convention while submitting your work : "Firstname_Lastname_hw3", so that we can easily recognize your submission. Those who work in groups can use longer names: "Firstname1_Lastname1_Firstname2_Lastname2_Firstname3_Lastname3_hw3". I repeat, please make sure that you will give both your TA and me read access to your private forked repository.

## Piazza Collaboration
As usual, I allow you to post questions and replies, statements, comments, discussion, etc. on Piazza either using your names or anonymously. Remember that you cannot share your code and your solutions beyond your forkmate group, but you can ask and advise others using Piazza on where resources and sample programs can be found on the internet, how to resolve dependencies and configuration issues, and how to design the logic of the algorithm, as usual. Yet, your implementation should be your own and you cannot share it beyond your forkmate group. Alternatively, you cannot copy and paste someone else's implementation and put your name on it. Your submissions will be checked for plagiarism. When posting question and answers on Piazza, please select the appropriate folder, i.e., hw3 to ensure that all discussion threads can be easily located.

## Submission
Submission deadline: Wednesday, December 13 at 10PM CST. Your submission will include your source code, the SBT and Gradle build configurations, the IntelliJ project, the README.md file in the root directory that contains the description of your implementation, how to compile and run it, and what are the limitations of your implementation. You should describe what JSL rules you implemented and how their work.

THE INSTRUCTOR (and the TA) WILL NOT ANSWER ANY REQUESTS FROM STUDENTS STARTING 7PM THE NIGHT BEFORE THE SUBMISSION DEADLINE.

## Evaluation criteria:
- the maximum grade for this prokect is 25 Points are subtracted from this maximum grade: for example, saying that 2% is lost if some requirement is not completed means that the resulting grade will be 25%-2% => 23%;
- no comments or highly insufficient comments: up to 15% lost;
- no tests that include various configuration profiles: up to 15% lost;
- the generator's code does not compile or it crashes without completing the core functionality: up to 25% lost;
- the generated code does not compile: up to 20% lost;
- the generator simply outputs a set of hardcoded strings as a generated program: 25% lost;
- the documentation is missing or insufficient to understand how to compile and run your program: up to 20% lost;
- the minimum grade for this course project cannot be less than zero.