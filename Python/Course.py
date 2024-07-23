#Project name: Course
#Purpose: Module for Final Project
#Developer: Miriam Wetstein
#Date: 1/2/23

from re import U
import os
import pickle
import Student
import Roster
from tkinter import messagebox
               
#Class: courses
#purpose: add courses
class Course(object):
    #creates list of all courses
    global courseList
    courseList = []
    
    #Create new course and add to list
    def __init__(self, course):
        self.course = course
        if self.course not in courseList:
            messagebox.showinfo("New Course","A new course has been created")
            courseList.append(self.course)
         

#If this module is run, tell the user it is only a module
if __name__ == "__main__":
   print("This is a module and is meant to be imported.")          
