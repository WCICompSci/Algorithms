def Fibonacci(init_num):
    if init_num == 0 or init_num == 1:
        return 1
    else:
        return Fibonacci(init_num-1) + Fibonacci(init_num-2)

for n in range(24):
    print(Fibonacci(n))
