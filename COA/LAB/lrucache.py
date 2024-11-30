def contains(arr, n):
    for i in range(len(arr)):
        if arr[i][0] == n:
            return True
    return False

def getInRank(arr, n):
    for i in range(len(arr)):
        if arr[i][1] == n:
            return i

def getInEle(arr, n):
    for i in range(len(arr)):
        if arr[i][0] == n:
            return i

def push(arr, n):
    if not contains(arr, n):
        x = getInRank(arr, 3)
        arr[x][0] = n
        arr[x][1] = 0
        for i in range(len(arr)):
            if i != x:
                arr[i][1] += 1
        return 0
    else:
        x = getInEle(arr, n)
        l = arr[x][1]
        arr[x][1] = 0
        for i in range(len(arr)):
            if i != x and arr[i][1] <= l:
                arr[i][1] += 1
        return 1

if __name__ == "__main__":
    memory = []
    for i in range(4):
        memory.append(['X', 4 - 1 - i])
    h = 0
    r = 0

    while True:
        print("\nMenu\n1.Push element to cache\n2.Display cache\n3.Print Hit Rate and Miss Ratio\n4.Exit")
        choice = int(input("\nEnter Choice:"))
        if choice == 1:
            n = int(input("Enter element to be pushed to cache: "))
            h += push(memory, n)
            r += 1
            print(n, " Has been successfully pushed to cache")
        elif choice == 2:
            print("\nPF Age")
            for i in memory:
                print(i)
        elif choice == 3:
            if r == 0:
                print("\nEnter an element first")
                continue
            hr = (h / r) * 100
            mr = 100 - hr
            print(f"\nNumber of Hits: {h}\nNumber of References: {r}")
            print("\nHit Rate: ", hr, "%\nMiss Ratio: ", mr, "%")
        elif choice == 4:
            print("Exiting Program \n")
            exit()
        else:
            print("Invalid Choice")
