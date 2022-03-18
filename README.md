# CompetitionGame

Create a web application for a programming competition game. For this, you have to implement two pages:  
1. A submission page, where a player writes his name, selects a task from provided list, writes code solution and submits. For example, select a Fibonacci algorithm task and then write it in C# or other selected language. The language selection can be hardcoded or visible in UI if you decide so. You can describe how the input test will be taken in the description. 

You can predefine tasks in DB with four columns: task name, description, test input parameter with which the  solution code will be submitted (compiled and run) and output parameter with which the submission output will be  compared to determine success/failure. Preload the DB with a couple of example tasks.  
2. Scores page with a table providing top 3 players with most successful submissions: player nickname, number of successful submissions, names of solved tasks. 

Hints:  
1. You don't have to write your own compiler, you can use https://jdoodle.com/compiler-api or other online  compiler API. It is enough to accept only one language for submitted solution code. 
2. You don't have to implement authentication/login unless you have spare time for it. If not, just let the player to type his name. 
3. It is enough to use a basic/default template. Just make it clean. 
4. You can develop the backend in your selected language, preferably C# or Java. You can choose a web technology (WebAPI + SPA) and DB on your own as well. 
5. Feel free to use your creativity and make your own assumptions if something is unclear or just ask us :)

