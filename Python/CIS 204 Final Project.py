#Project name: CIS 204 Final Project
#Purpose: Adding reportcard and transcript to assgn10
#Developer: Miriam Wetstein
#Date: 1/2/23

from re import U
import os
import pickle
import Course
import Roster
import Student
global gradeBook
from tkinter import *
from tkinter import ttk
from tkinter import messagebox
from tkinter import simpledialog


#Class for creating the GUI 
class Application(Frame):
    #initializing the window with label and buttons
    def __init__(self, master):
        super(Application,self).__init__(master)
        self.grid()
        self.lbl = ttk.Label(self, text="Welcome to WITS student database! \nSelect an option below:\n").grid(row=0, column=0, sticky='w')
        #Button for each of the options. they cause a method to run
        self.btn = ttk.Button(self, text="Add Student (by name or file)", command=self.addStudentButton)
        self.btn1 = ttk.Button(self, text="Add/Edit Course & Grade", command=self.addCourseButton)
        self.btn2 = ttk.Button(self, text="Lookup Student's Grade", command=self.lookupStudentButton)
        self.btn3 = ttk.Button(self, text="Print Gradebook", command=self.printGradebookButton)
        self.btn4 = ttk.Button(self, text="Save", command=self.saveButton)
        self.btn5 = ttk.Button(self, text="Create reportcard", command=self.reportcardButton)
        self.btn6 = ttk.Button(self, text="Create transcript", command=self.transcriptButton)
        self.btn7 = ttk.Button(self, text="Quit", command=root.destroy)
        # if assigning to a variable, you need to to call the grid method in order to have it placed
        self.btn.grid(sticky='w')
        self.btn1.grid(sticky='w')
        self.btn2.grid(sticky='w')
        self.btn3.grid(sticky='w')
        self.btn4.grid(sticky='w')
        self.btn5.grid(sticky='w')
        self.btn6.grid(sticky='w')
        self.btn7.grid(sticky='w')
        root.attributes("-topmost", True)
        self.lbl1 = ttk.Label(self, text="\n\n(Please make sure to type all entries \n correctly, including capitalization, \n for every popup box.)").grid(row=50, column=0)
    #when this button clicked, pop up for student name
    def addStudentButton(self):
        newStudent = simpledialog.askstring(title="New Student",prompt="Enter name of new student. Or enter 2 to add from a txt file")
        if newStudent == "2":
            #getting students from file
            try:
                fileLocation = simpledialog.askstring(title="File Location", prompt ="Enter location of your file")
                #change to directory containing file
                os.chdir(fileLocation)
                fileName = simpledialog.askstring(title="File Name", prompt ="Enter name of your file with the .txt")
                fileStudents = open(fileName,"r")
                #create list of the students
                lines = fileStudents.readlines()
                
                #remove enter from the end of student names
                for line in lines:
                    
                    newLine = ""
                    for letter in line:
                        if letter != "\n":
                            newLine +=letter
                    #if student in gradebook, tell user. otherwise, add them to the gradebook
                    if newLine in Student.studentList:
                        messagebox.showwarning("Duplicate Student", newLine+" is already in your gradebook")
                        
                    else:
                        
                        #create student in student module and add dictionary of the student using roster module
                        newLine = Student.Student(newLine, studentID)
                        
                        roster.addDict(newLine)
                        
                        
                fileStudents.close()
            except:
                messagebox.showwarning("Error", "File name or location is invalid")
            
        else:
            #student already in the student list
            if newStudent in Student.studentList:
                messagebox.showwarning("Duplicate Student", "This student is already in your gradebook")
            else:
                #create a new student for the student list and new dict in roster
                newStudent = Student.Student(newStudent, studentID)
                roster.addDict(newStudent)
        
    def addCourseButton(self):
        
        #Pop up asks user for student name to add to course
        whichStudent = simpledialog.askstring(title="New Course",prompt="Enter student's name that you would like to enroll in a course")
        
        #If the student exists, they are prompted for the course and grade
        if whichStudent in Student.studentList:
            #Pop up asks user for course name to add 
            newCourse = simpledialog.askstring(title="New Course",prompt="What course would you like to add or edit the student's grade for?")
            
            #Pop up asks user for grade to add 
            newGrade =  simpledialog.askstring(title="New Course",prompt="What grade did the student get in this course?")
            newGrade = newGrade.capitalize()
            newcomment =  simpledialog.askstring(title="New Comment",prompt="What comment do you want to add?")
            semester = simpledialog.askstring(title="Semester",prompt="Which semester is this course for? press 1 for Fall 2022, press 2 for Spring 2023")
            if semester == "1":
                semester = "Fall 2022"
                roster.enroll(newCourse, whichStudent, newGrade, newcomment, semester) 
            elif semester == "2":
                semester = "Spring 2023"
                #passes course, student, grade into enroll method in roster module 
                roster.enroll(newCourse, whichStudent, newGrade, newcomment, semester)
            else:
                messagebox.showwarning("Sorry", "That is not one of the semester options")
        else:
            messagebox.showwarning("Sorry", "That is not the name of one of your students")
    def updateText(self):
        print("hi")    
    def lookupStudentButton(self):
        #User is promped for student and course to lookup
        whichStudent = simpledialog.askstring(title="Lookup",prompt="Which student are you looking up?")
        
        whichCourse = simpledialog.askstring(title="Lookup",prompt="Which course do you want to lookup?\n")
        
        #passes the student and course in the lookup method in roster module
        roster.lookUp(whichStudent,whichCourse)

    def printGradebookButton(self):
        #Text for the widget formatted
        txtDesc = Text(root,width = 25, height = 40, wrap=WORD)
        txtDesc.grid(row=7,column=0,columnspan=2,sticky=W)
        #clear out the text box
        txtDesc.delete(0.0,END)
        #Fill with report card
        txtDesc.insert(0.0,roster.printReportCard())

    def saveButton(self):
        #Sets directory to whatever it was when the program opened
        dir_containing_file = current_directory
        os.chdir(dir_containing_file)
        print(current_directory)
        #runs the save method on roster
        roster.save()

    def reportcardButton(self):
        #calls reportcard method
        roster.reportcard()

    def transcriptButton(self):
        #calls transcript method
        roster.transcript()


#creates new roster from Roster module           
global roster
roster = Roster.Roster() 
global newStudent

#keeps track of the current directory to later save the binary file in
global current_directory
current_directory = os.getcwd()
#starts the studentID count
global studentID
studentID = 1
#create root window
root = Tk()
# create title
root.title("WITS Program")
#sizing
root.geometry("200x400")
app = Application(root)
root.mainloop()    

             
