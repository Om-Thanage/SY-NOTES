def binary(n,x):
    revlst=[]
    lst=[]
    for i in range(x):
        revlst.append(n%2)
        n=n//2
    for i in range(x):
        lst.append(revlst[x-1-i])  
    return lst

#Function to add two binary numbers
def add(a,b):
    c=a
    for i in range(len(a)-1,-1,-1):
        if b[i]==1:
            for j in range(i,-1,-1):
                if c[j]==0:
                    c[j]+=1
                    break
                
                elif c[j]==1:
                    c[j]=0
                    continue  
    return c

#Function to get 2s complement of binary number
def comp(arr):
    temp=arr
    #1s complement
    for i in range(len(arr)):
        if temp[i]==0:
            temp[i]=1
        elif temp[i]==1:
            temp[i]=0
    #add 1
    for i in range(len(arr)-1,-1,-1):
        if temp[i]==0:
            temp[i]+=1
            break   
        elif temp[i]==1:
            temp[i]=0
            continue                
    return temp

#Function to rightshift
def rightShift(arr):
    for i in range(len(arr)-1,0,-1):
        arr[i]=arr[i-1]        
    return arr

# Main Code
num1=int(input("Enter 1st number: "))
num2=int(input("Enter 2nd number: "))

for i in range(0,10000):
    if num1<2**i:
        x=i
        break


for i in range(0,10000):
    if num2<2**i:
        y=i
        break
bits=x+y

M=binary(num1,bits)
Mc=comp(binary(num1,bits))

A=[0]*bits
Q=binary(num2,bits)
Q1=[0]
count=bits

R=A+Q+Q1

print("\nQ = ",Q)
print("\nA = ",A)
print("\nM = ",M)
print("\n-M = ",Mc)
print("\ncount = ",bits)
print("\n")

print("\nStart")
print(R[:bits],R[bits:2*bits],R[2*bits:],count) 
for i in range(bits):
    
    if R[-2:]==[0,0] or R[-2:]==[1,1]:
        print("\nRight Shift") 
        R=rightShift(R)
        count-=1
        
    elif R[-2:]==[1,0]:        
        print("\nA=A-M")
        temp=R[:bits]
        temp=add(temp,Mc)
        R[:bits]=temp
        print(R[:bits],R[bits:2*bits],R[2*bits:],count) 
        print("\nRight Shift")                
        R=rightShift(R)
        count-=1
        
    elif R[-2:]==[0,1]:
        print("\nA=A+M")
        temp=R[:bits]
        temp=add(temp,M)
        R[:bits]=temp 
        print(R[:bits],R[bits:2*bits],R[2*bits:],count)                
        print("\nRight Shift")        
        R=rightShift(R)
        count-=1 
    print(R[:bits],R[bits:2*bits],R[2*bits:],count) 

answer=R[bits:2*bits]
print(f"\nAnswer in binary is {answer}")

sum=0
for i in range(bits):
        sum+=answer[i]*2**(bits-1-i)
print(f"\nAnswer in decimal is {sum}")    


