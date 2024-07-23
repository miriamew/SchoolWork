#Project name: Student
#Purpose: Module for Final Project
#Developer: Miriam Wetstein
#Date: 1/2/23

from re import U
import os
import pickle
import Roster
import Course
from tkinter import messagebox
               
# Class: Students
# Purpose: add students

class Student(object):
    #creates list of all students
    global studentList
    studentList=[]
    #create list of all studentIDs
    global studentIDList
    studentIDList = []
    
    #creates new student and adds to list
    def __init__(self, name, studentID):
        self.name=name
        self.studentID = studentID
        messagebox.showinfo("New Student","A new student ("+name+") has been added")
        #adds studentID to list then increments
        studentList.append(self.name)
        
        self.studentID = str(studentID+studentList.index(self.name)).zfill(5)
        studentIDList.append(self.studentID)   
        
#If this module is run, tell the user it is only a module
if __name__ == "__main__":
    print("This is a module and is meant to be imported.")
            
