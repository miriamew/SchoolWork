
leftchild =[]
values = []
rightchild = []
tree = False
i = 0
def in_order_traversal(node):
    if node != -1:
        #print(leftchild)
        #print(values)
        #print(rightchild)
        
        #print(leftchild[node])
        in_order_traversal(leftchild[node])
        print(values[node], end=" ")
        #print(rightchild[node])
        in_order_traversal(rightchild[node])

while i < 12:
    i = i+1
    newnum = int(input("Input number: \n"))
    values.append((newnum))
    leftchild.append(-1)
    rightchild.append(-1)
    upto = 0
    while upto < len(values)-1:
        if newnum <= values[upto]:
            if leftchild[upto] == -1:
                leftchild[upto] = len(values)-1
            else:
                upto = leftchild[upto]
        if newnum > values[upto]:
            if rightchild[upto] == -1:
                rightchild[upto] = len(values)-1
            else:
                upto = rightchild[upto]

print("In-order traversal:")
in_order_traversal(0)

    



