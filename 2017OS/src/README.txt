Damian Gavin, Operating Systems Project 2017/2018. Student No. 10007969.

Multi-threaded TCP Server Application.

************************************************************************************************

Due to unforseen circumstances I was unable to complete this project on time, However I have got the client and server communicating and have some of the project requirements running.

I was unable to connect to my Virtual Machine so I have been running it locally on my own Computer.
To run my application you first need to "Run" the server as a Java application. A message will appear in the console "Server Started". Then you change to the client within the client package and run that as a Java application. You will now be prompted to enter your IP address, Here I was using 127.0.0.1 as I was not connected to the VM, If you are running it on a VM you can enter the IP address of that machine here.

I have hardcoded port number 44444 into both client and server so they can connect.

After a welcome message you are presented with a menu of four options, 1 is to add a user, after selecting this option you will be directed to a new menu requiring personal details such as name, height, weight and password. This password will be used to access the record later on.

When you start this server there is no data stored so you are starting from a blank slate. The entered data will be stored temporarily, but it will be written out to a file called users.txt and you can access it at any time while the server is running by selecting option 2 from the menu, However I did not get reading the data from a file completed so if the server is closed the data is lost.

Menu option 3 will display the users details, again this will be lost if the server is closed.

Menu option 4 will exit the system and present with a session terminated message.

This project was mostly adapted from the labs we completed throughout the Semester.