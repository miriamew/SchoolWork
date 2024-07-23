#Miriam Wetstein - Project 1 - Pig Latin

eng = input ("Input english sentence\n")
pig = ""
vowels = "aeiouy"
exceptions = "chghshthrhphwhwr"
go = True
while go == True:
    
    spaceAt = (eng.find(" "))
    if (spaceAt == -1):
        go = False
        spaceAt = len(eng) -1  
    word = (eng[0: spaceAt])
    eng = eng[spaceAt + 1: len(eng)]   
    if (vowels.find(word[0]) != -1):
        pig = pig + (word + "ay ")
    elif (exceptions.find(word[0:2]) != -1):
        pig = pig + (word[2:len(word)] + word[0:2] + "ay ")
    else:
        pig = pig + (word[1:len(word)] + word[0] + "ay ")
pig = pig[0:len(pig)-1] + "."
print(pig)