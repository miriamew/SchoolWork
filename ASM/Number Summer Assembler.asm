; Program4 Miriam Wetstein - Fibonacci: input 2 multidigit and number of rounds (6-10), program has to run twice (loop), output all terms
    .MODEL FLAT
    .386
    .STACK 100h
    .DATA
num1        DD       0
num2        DD       0
COUNT       DD       5
runtwice    DD       2
TestAnswer  DD       178
getnum      DB       10, 13, 'Enter Number: ', '$'
getcount    DB       10, 13, 'Enter Count: ', '$'
TEN         DD       10
zero        DD       0
MSG1	    DB	     10, 13, 'The Number is: ' 
SPOT1       DB       '      ', '$'

    .CODE

PUTMSG  MACRO   MYMESSAGE
        mov dx, OFFSET MYMESSAGE
        mov ah, 9h
        int 21h
        ENDM


PRGM4      Proc    
        mov ax, @DATA
        mov ds, ax
        
LOOP2:
        MOV EDX, zero
        MOV spot1[0], DL
        MOV spot1[1], DL
        MOV spot1[2], DL
        MOV spot1[3], DL
        MOV spot1[4], DL
; set num1 to zero
        sub EAX, EAX
        mov num1, EAX
        sub EBX, EBX
        mov num2, EBX
; read in first number
        PUTMSG getnum
        
CHARIN1:  
        mov ah, 1h 
        int 21h
; check if it is a CR 
        CMP al, 13              ; 13 is an immediate value, isnt stored
        JE  NEXTNUM            ;Jump if they are equal
        sub al, 30h
        sub EBX, EBX
        mov bl, al
        mov EAX, num1
        imul TEN                ;multiplication of numbers. must be in EAX to multiply. both numbers must match sizes
        ADD EAX, EBX
        mov num1, EAX
        JMP CHARIN1
NEXTNUM:
; set num2 to zero
        sub EAX, EAX
        mov num2, EAX
; read in second number
        PUTMSG getnum
        

CHARIN2:  
        mov ah, 1h 
        int 21h
; check if it is a CR 
        CMP al, 13              ; 13 is an immediate value, isnt stored
        JE  GETCT             ;Jump if they are equal
        sub al, 30h
        sub EBX, EBX
        mov bl, al
        mov EAX, num2
        imul TEN                ;multiplication of numbers. must be in EAX to multiply. both numbers must match sizes
        ADD EAX, EBX
        mov num2, EAX
        JMP CHARIN2

;get Count

GETCT:
; set count to zero
        sub EAX, EAX
        mov count, EAX
; read in second number
        PUTMSG getcount
        
CHARIN3:  
        mov ah, 1h 
        int 21h
; check if it is a CR 
        CMP al, 13              ; 13 is an immediate value, isnt stored
        JE  CALC             ;Jump if they are equal
        sub al, 30h
        sub EBX, EBX
        mov bl, al
        mov EAX, count
        imul TEN                ;multiplication of numbers. must be in EAX to multiply. both numbers must match sizes
        ADD EAX, EBX
        mov count, EAX
        JMP CHARIN3

CALC:
        
        mov EAX, num1
        mov EBX, num2
        add EAX, EBX
        mov num1, EBX
        mov num2, EAX
CHAROUT1:
        sub EAX, EAX
        sub EDX, EDX
        mov EAX, num2
        mov ECX, 5
DIVLOOP1:
        CDQ                     ;stretches number so makes souble into quartiary, putting zeros in front of EAX by putting them in EDX
        IDIV TEN                ;quotient in EAX, remainder in EDX
        ADD EDX, 30h
        MOV SPOT1+[ECX], DL     ;moves it to 6th places in the spot variable (which is 5th after the first)
        CMP EAX, zero
        JE PRINT1
        DEC ECX
        JMP DIVLOOP1
PRINT1:
        PUTMSG MSG1
        DEC count
        JNZ CALC
CHCKTWIC:
        DEC runtwice
        JNZ loop2


DONE:   mov al, 0
        mov ah, 4ch
        int 21h
PRGM4  ENDP
        END PRGM4