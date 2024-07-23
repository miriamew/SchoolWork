#Project name: Roster
#Purpose: Module for Final Project
#Developer: Miriam Wetstein
#Date: 1/2/23

from re import U
import os
import pickle
import Student
import Course
from tkinter import *
from tkinter import ttk
from tkinter import messagebox
from tkinter import simpledialog

#class: roster
#purpose: keep track of courses and grades that students are enrolled in
class Roster(object):
    global info
    #_init_ creates roster list and opens the saved file
    def __init__(self):
        global roster
        roster = []
        
        try:
            fileGrades = open("grades.dat","rb")
            #importing the lists from binary file
            Student.studentList = pickle.load(fileGrades)
            Student.studentIDList = pickle.load(fileGrades)
            Course.courseList = pickle.load(fileGrades)
            roster = pickle.load(fileGrades)
            fileGrades.close()
            #Box pops up with message of if the gradebook was loaded
            messagebox.showinfo("Gradebook","previous gradebook loaded")
            
        except:
            messagebox.showinfo("Gradebook","No previous gradebook found. Starting new gradebook")
            
    


    #makes a dictionary named with the student name. then adds it to the roster list   
    def addDict(self, studentName):
        global studentdict
        studentdict = studentName
        #dictionary starts of blank
        studentdict={}
        #roster has list of all the dictionaries
        roster.append(studentdict)
        print(roster)
        
    #takes course, student, grade and enrolls the student in that course
    def enroll(self, courseName, student, grade, comment, semester):
        
        #checks if student exists then saves the position of the student in the studentList
        if student in Student.studentList:
            origPosition = (Student.studentList.index(student))
            
            #student becomes dictionary of the dictionary saved in the roster in that position
            student=roster[origPosition]
            #the key of the course and the value of the grade gets added to that dictionary
            student[courseName]=[grade, comment, semester]
            
            #the roster gets updated with the new student dictionary
            roster[origPosition]=student

         #course gets added to courseList using course method in course module   
        courseName = Course.Course(courseName)
        
        
    #prints whole gradebook
    def printReportCard(self):
        message=""
        #runs through students, prints name
        for name in Student.studentList:
            message+=(name+":\n")
            try:
                #creates list of courses then list of info of each course
                name = roster[Student.studentList.index(name)]
                for key in name.keys():
                    courses = name.get(key)
                    #prints course and grade by adding it to the message
                    message+=(" "+ key+": "+ courses[0]+"\n")
            except:
                continue
        return message



    #creates file of reportcard
    def reportcard(self):
        #get input for student name and file name
        studentName = simpledialog.askstring(title = "student name", prompt = "Which student do you want a report card for?")
        filename = simpledialog.askstring(title="File name",prompt="Enter what you would like the name of this file to be? Please write name.txt")
        filename = open(filename,"w")
        filename.writelines( studentName + "'s Report Card\n\n")
        #create list of all courses for the students
        if studentName in Student.studentList:
            studentName = roster[Student.studentList.index(studentName)]
            for key in studentName.keys():
                #create list for each course of all the information then add to file
                courses = studentName.get(key)  
                filename.writelines(key + "-"+ courses[2]+ ":\nGrade:" + courses[0]+"\n" + "Comment:" + courses [1]+"\n\n")
        else:
            messagebox.showwarning("Sorry", "That is not the name of one of your students")
        
        filename.close()
        messagebox.showwarning("Success!", "Your reportcard has been saved")
    
    

    #Creates file of transcript
    def transcript(self):
        total = 0
        counter = 0
        #Get input for student name and file name
        studentName = simpledialog.askstring(title = "student name", prompt = "Which student do you want a transcript for?")
        filename = simpledialog.askstring(title="File name",prompt="Enter what you would like the name of this file to be? Please write name.txt")
        filename = open(filename,"w")
        #create student ID string
        studentID = str(Student.studentIDList[Student.studentList.index(studentName)])
        filename.writelines("Transcript for " + studentName + ":\n studentID: " + studentID + "\n")
        #Create list of student's courses
        if studentName in Student.studentList:
            studentName = roster[Student.studentList.index(studentName)]
            #create list of all information about each course
            for key in studentName.keys():
                courses = studentName.get(key)
                #calculate GPA
                counter+=1   
                if courses[0] == "A":
                    total +=4
                if courses[0]=="B":
                    total+=3
                if courses[0]=="C":
                    total+=2
                if courses[0]=="D":
                    total+=1
                #Adds all info about the course to the file
                filename.writelines("\n"+key + " - "+ courses[2]+ ":\nGrade:" + courses[0] + "\n")
            if counter>0:
                GPA = str(total/counter)
            else: 
                GPA = ""
            filename.writelines("\tGPA:")
            filename.write(GPA)
            filename.close()
            messagebox.showwarning("Success!", "Your transcript has been saved")
        else:
            messagebox.showwarning("Sorry", "That is not the name of one of your students")
            


    #adds student to the roster
    def addToRoster(self,student):
        roster.append(student)
    

    #checks the grade of a student in a specific course    
    def lookUp(self, student, course):
        #checks that student is in student lsit
        if student in Student.studentList:
            if course in Course.courseList:
                    #prints the students name, course, grade
                    message=student+"'s grade in "+course+" is:"
                    #checks the index of the student in the list so can access the students courses in roster
                    position = Student.studentList.index(student)
                    newDict = roster[position]
                    #pop up box of student, course, grade
                    courses = newDict.get(course)
                    messagebox.showinfo("Lookup", (message,courses[0]))
                    
                    
            #Pop up box if course or student doesn't exist    
            else:
                messagebox.showwarning("Error","Course doesn't exist")
                
        else:
            messagebox.showwarning("Error","student doesn't exist")
                


    #Function Name: save
    #Purpose: saves the current gradebook to a binary file
    #Parameters: none
    #Return value: none
    def save(self):
        #opens the file and dumps the gradebook in
        fileGrades = open("grades.dat","wb")
        pickle.dump(Student.studentList, fileGrades)
        pickle.dump(Student.studentIDList, fileGrades)
        pickle.dump(Course.courseList, fileGrades)
        pickle.dump(roster, fileGrades)
        fileGrades.close()
        messagebox.showinfo ("Saved","Your gradebook has been saved")



#lets user know this is a module    
if __name__ == "__main__":
   print("This is a module and is meant to be imported.")