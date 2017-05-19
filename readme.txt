This web application is a java EE app.
It provides a service to solve the maze problem using the maze library.

The REST service expects a GET method, for example directly in Firefox: 

http://163.172.42.155/mazeweb/tide/mazeservice/drawPathForEscape?startX=3&startY=1&labyrinth=OOOOOOOOOO&labyrinth=OWWWWOWWWO&labyrinth=OWOOWOWOWO&labyrinth=OWWOWOWOWO&labyrinth=OWOOWWWOWW&labyrinth=OWOOOOOOOO&labyrinth=OWWWWWWWWO

The method name is drawPathForEscape and you need to provide the following params:
- startX
- startY
- n times labyrinth=description to describe each line of the labyrinth.
    - O is for WALL
    - W is for EMPTY (I used W instead of ' ' because working whith white spaces in URLs is not easy)

This service returns a JSON representation of the solution or null (nothing) if there is no escape.
