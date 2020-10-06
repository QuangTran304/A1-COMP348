students(ash,40096265).
students(eric,40113678).
students(quang,27740654).
students(parsa,40179383).
students(X):-students(X,_).

courses(comp348).
courses(comp352).
courses(civi231).
courses(comp232).
courses(elec275).
courses(engr202).
courses(comp335).
courses(engr371).
courses(encs282).
courses(soen6461).

stcourses(ash,comp348).
stcourses(ash,comp352).
stcourses(ash,civi231).
stcourses(eric,comp348).
stcourses(eric,comp232).
stcourses(eric,elec275).
stcourses(eric,engr202).
stcourses(quang,comp348).
stcourses(quang,comp335).
stcourses(quang,engr371).
stcourses(quang,encs282).
stcourses(parsa,comp348).
stcourses(parsa,soen6461).

stcourses(X,Y):-students(X,Z),stcourses(Z,Y).




/*
students(Student),findall(S,stcourses(Student,S),ListofCourses).   

findall(X,students(X),List),length(List, N).   

findall(X,stcourses(_, X), List),list_to_set(List,Set).  

findall(X,stcourses(_, X), Lst),list_to_set(Lst,Set),sort(Set, Sort_set).  

findall(X,stcourses(_, X), List),list_to_set(List,Set),sort(Set, Sort_set),
[A,B|C] = Sort_set.

 * /
