flag = True
cnt = 1
while flag:
    input_ = input().split(" ")
    l = int(input_[0])
    p = int(input_[1])
    v = int(input_[2])

    if l == 0 & p == 0 & v == 0:
        flag = False
        break

    result = (v // p) * l + (v % p if v % p <= l else l)

    print("Case {}: {}".format(cnt, result))

    cnt += 1

"""
edge case
5 8 4
5 8 6
10 20 28
0 0 0
"""
