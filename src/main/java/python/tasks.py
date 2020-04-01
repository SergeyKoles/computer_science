# def update_dictionary(d, key, value):
#     if key in d:
#         d[key] += [value]
#     elif (2 * key) in d:
#         d[2 * key] += [value]
#     else:
#         d[2 * key] = [value]
#
# d = {}
# print(update_dictionary(d, 1, -1))  # None
# print(d)                            # {2: [-1]}
# update_dictionary(d, 2, -2)
# print(d)                            # {2: [-1, -2]}
# update_dictionary(d, 1, -3)
# print(d)                            # {2: [-1, -2, -3]}

# def word_counter():
#     words = input().lower().split(' ')
#     d = {}
#     for word in words:
#         w = word
#         if w not in d:
#             d[w] = 1
#         else:
#             d[w] += 1
#     for k, v in d.items():
#         print(k, v, ' ')
#
# word_counter()


# cache = {}
#
# n = int(input())
# for i in range(n):
#     x = int(input())
#     if cache.get(x):
#         print(cache[x])
#     else:
#         fx = f(x)
#         cache[x] = fx
#         print(cache[x])

# def modify_list(l):
#     for i in range(len(l)-1, -1, -1):
#         cur = l[i]
#         if (cur % 2) == 0:
#             l[i] = cur // 2
#         else:
#             l.remove(cur)
#
# lst = [1, 2, 3, 4, 5, 6]
# lst = [1, 2, 300, 4, 5, 1000]
# print(modify_list(lst))  # None
# print(lst)               # [1, 2, 3]
# modify_list(lst)
# print(lst)               # [1]
#
# lst = [10, 5, 8, 3]
# modify_list(lst)
# print(lst)               # [5, 4]


# with open('file.txt', 'r') as inf:
#     str = inf.readline()
#
# n = ''
# simbol = ''
# res = ''
# i = 0
# while i < len(str):
#     if not str[i].isdigit():
#         simbol = str[i]
#         i += 1
#         continue
#
#     while i < len(str) and str[i].isdigit():
#         n += str[i]
#         i += 1
#     res += simbol * int(n)
#     n = ''
#
# with open('result.txt', 'w') as out:
#     out.write(res)


