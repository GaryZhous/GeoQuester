# GeoQuester
This is a Geographic Information Software developed in C++ for our software design course ECE297. We used GTK graphics library to construct the canvas and those interactive widgets, with geographical data from OpenStreetMap API. Resembling Google Maps (well not really), it offers several intriguing features, including:
  * Annotation (We used SQLite to store user's annotation data)
  * Intersection highlighting & Information display
  * Finding shortest paths between intersections (with animation)

### Overview
<img src="https://github.com/GaryZhous/GeoCacher/blob/main/Overview.png">

### User's Annotation
<img src="https://github.com/GaryZhous/GeoCacher/blob/main/UserData.png">

### Shortest Path Finding with Animation
![](https://github.com/GaryZhous/GeoCacher/blob/main/PathAnimated.gif)

### Traveling Courier Contest
At the end of the course, we were asked to design an effective solution to tackle a variant of TSP (Traveling Salesman Problem). We need to provide a courier with an optimum route to pick up and deliver all the items required starting from a depot and ending at the same depot. 
![](https://github.com/GaryZhous/GeoQuester/blob/main/Traveling_Courier_example.png)
The quality (route travel times) of the routes we found in various tricky test cases will be used in the leaderboard of this contest.
With a solid multi-destination Dijskra's algorithm and a good greedy path reconstruction approach, our solution ranked #9 among 91 teams.
<img src="https://github.com/GaryZhous/GeoCacher/blob/main/TSP_Ranking.png">

**Due to the Academic Integrity rules of University of Toronto, this project is not open-sourced. But if you would like to know more about our design, feel free to contact us!**
  * [Gary](https://github.com/GaryZhous)
  * [Ayaan](https://github.com/N00dleMaster)
  * [Ahadu](https://github.com/AhaduH)
