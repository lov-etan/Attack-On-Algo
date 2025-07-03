
n = input()

max_val = 0
min_val = 100

def cnt (s) :
    total = 0
    for c in s : 
        i = int(c)
        if i % 2 != 0 :
            total+=1
    return total
    
def find (sum, curr) :
    if len(curr) == 1 :
        sum += cnt(curr)
        global max_val, min_val
        max_val = max(max_val, sum)
        min_val = min(min_val, sum)
        return
    elif len(curr) == 2 :
        sum += cnt(curr)
        next = int(curr[0]) + int(curr[1])
        find (sum, str(next))
    else :
        sum += cnt (curr)
        for i in range(0, len(curr) - 2) :
            for j in range(i+1, len(curr) - 1) :
                a = int(curr[:i+1])
                b = int(curr[i+1:j+1])
                c = int(curr[j+1:])
                find (sum, str(a + b + c))

find (0, n)

print(min_val, max_val)
