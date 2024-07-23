
letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
operations = "^*/+-X"
order = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
start = ""
while str(start) != "$":
    output = ""
    start = input("Put in an infix expression. type $ to quit\n")
    stack = []
    j = -1
    for letter in start:
        if letter in letters: #variable
            output = output + str(letter)
        if letter in operations:
            while (stack) and (stack[j] in operations) and (order[stack[j]] > order[letter]): #operator
                output = output + str(stack[j])
                stack.pop()
                j = j-1
            stack.append(letter)
            j = j+1
        if letter == "(":
            stack.append(letter)
            j = j+1

        if letter == ")": 
            while stack and stack[j] != "(":
                output = output + str(stack[j])
                stack.pop()
                j = j-1 
            stack.pop()  
            j = j-1
        
    while stack:
        output = output + str(stack[j])
        stack.pop()
        j = j-1
    print(output)




    


 





