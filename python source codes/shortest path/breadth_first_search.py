level = [
"WWWWWWWWWWXXWWWWWWWWWW",
"W                    W",
"W WWWWWWWWWWWWWWWWWW W",
"W W                W W",
"W W WWWWWW  WWWWWW W W",
"W W      W  W      W W",
"W W WWWW W  W WWWW W W",
"W W    W W  W W    W W",
"W WWWW W      W WWWW W",
"W      W WWWW W      W",
"W WWWWWW      WWWWWW W",
"W W      WXXW      W W",
"W WWWWW WWXXWW WWWWW W",
"X       WXXXXW       X",
"W WWWWW WWWWWW WWWWW W",
"W W                W W",
"W WWWWWW   X  WWWWWW W",
"W      W WWWW W      W",
"W WWWW W      W WWWW W",
"W W    W W  W W    W W",
"W W WWWW W  W WWWW W W",
"W W      W  W      W W",
"W W WWWWWW  WWWWWW W W",
"W W                W W",
"W WWWWWWWWWWWWWWWWWW W",
"W                    W",
"WWWWWWWWWWXXWWWWWWWWWW",
]

bx = int(input())
by = int(input())
ex = int(input())
ey = int(input())

step = []
col_length = len(level)
row_length = len(level[0])
for row in range(col_length+10):
    lis = []
    for col in range(row_length+10):
        lis.append(50)
    step.append(lis)
step[bx][by] = 0

x_queue = [bx]
y_queue = [by]

while x_queue:
    x = x_queue.pop()
    y = y_queue.pop()

    if x+1<col_length and step[x+1][y]>step[x][y]+1 and level[x+1][y]!='W':
        x_queue.append(x+1)
        y_queue.append(y)
        step[x+1][y] = step[x][y]+1
    if x-1>=0 and step[x-1][y]>step[x][y]+1 and level[x-1][y]!='W':
        x_queue.append(x-1)
        y_queue.append(y)
        step[x-1][y] = step[x][y]+1
    if y+1<row_length and step[x][y+1]>step[x][y]+1 and level[x][y+1]!='W':
        x_queue.append(x)
        y_queue.append(y+1)
        step[x][y+1] = step[x][y]+1
    if y-1>=0 and step[x][y-1]>step[x][y]+1 and level[x][y-1]!='W':
        x_queue.append(x)
        y_queue.append(y-1)
        step[x][y-1] = step[x][y]+1

print(step[ex][ey])

