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

# str = ''
#
# with open('file.txt', 'r') as inf:
#     for line in inf:
#         str += line.strip()
#
# words = str.split(' ')
# words.sort()
# dic = {}
# max_word = 0
# word = ' '
# for w in words:
#     k = w.lower()
#     if k in dic:
#         dic[k] += 1
#     else:
#         dic[k] = 1
#     if any(dic) and dic[k] > max_word:
#         max_word = dic[k]
#         word = k
#
#
# result = []
# for w in words:
#     k = w.lower()
#     if dic[k] == max_word and k not in result:
#         result += [w]
#         result += [max_word]
#
# print(result, end=' ')

# stud = []
# mat = []
# fiz = []
# rus = []
# avr_stud = []
# i = 0
# entry = []
# with open('file.txt', 'r') as inf:
#     for line in inf:
#         line = line.strip()
#         entry = line.split(';')
#         stud += entry[0]
#         mat += [int(entry[1])]
#         fiz += [int(entry[2])]
#         rus += [int(entry[3])]
#         avr_stud += [(int(mat[i]) + int(fiz[i]) + int(rus[i])) / 3]
#         i += 1
#
# mat_avr = 0
# fiz_avr = 0
# rus_avr = 0
#
# for st in range(i):
#     mat_avr += mat[st]
#     fiz_avr += fiz[st]
#     rus_avr += rus[st]
#
# mat_avr /= i
# fiz_avr /= i
# rus_avr /= i
#
# with open('result.txt', 'w') as ouf:
#     for st in range(i):
#         ouf.write(str(avr_stud[st]))
#         ouf.write('\n')
#     ouf.write(str(mat_avr))
#     ouf.write(' ')
#     ouf.write(str(fiz_avr))
#     ouf.write(' ')
#     ouf.write(str(rus_avr))


# import sys
# args = sys.argv
# del args[0]
# print(*args)

# import requests
# r = requests.get('http://example.com')
# print(r.text)

# url = 'https://stepic.org/media/attachments/course67/3.6.2/383.txt'
# par = {'key1': 'value1', 'key2': 'value2'}
# r = requests.get(url, params=par)
# r = requests.get(url)
# text = r.text.strip().splitlines()
# print(r.text)
# with open('result.txt', 'w') as ouf:
#         ouf.write(r.text)

# init_url = "https://stepic.org/media/attachments/course67/3.6.3/699991.txt"
# prefix = 'https://stepic.org/media/attachments/course67/3.6.3/'
# r = requests.get(init_url)
# file_name = r.text.strip()
# while True:
#     if file_name.startswith('We'):
#         print(file_name)
#         break
#     else:
#         url = prefix + file_name
#         r = requests.get(url)
#         file_name = r.text
#
# n = int(input())
# table = {}
# for i in range(n):
#     line = input().strip().split(';')
#     team1 = line[0]
#     gol_team1 = int(line[1])
#     team2 = line[2]
#     gol_team2 = int(line[3])
#     if gol_team1 > gol_team2:
#         w1 = 1
#         w2 = 0
#         p1 = 3
#         p2 = 0
#         d = 0
#     elif gol_team2 == gol_team1:
#         w1 = 0
#         w2 = 0
#         p1 = 1
#         p2 = 1
#         d = 1
#     else:
#         w1 = 0
#         w2 = 1
#         p1 = 0
#         p2 = 3
#         d = 0
#
#     if team1 in table:
#         cur_result1 = table[team1]
#         cur_result1[0] += 1
#         cur_result1[1] += w1
#         cur_result1[2] += d
#         cur_result1[3] += w2
#         cur_result1[4] += p1
#     else:
#         cur_result1 = []
#         cur_result1 += [1]
#         cur_result1 += [w1]
#         cur_result1 += [d]
#         cur_result1 += [w2]
#         cur_result1 += [p1]
#         table[team1] = cur_result1
#     if team2 in table:
#         cur_result2 = table[team2]
#         cur_result2[0] += 1
#         cur_result2[1] += w2
#         cur_result2[2] += d
#         cur_result2[3] += w1
#         cur_result2[4] += p2
#     else:
#         cur_result2 = []
#         cur_result2 += [1]
#         cur_result2 += [w2]
#         cur_result2 += [d]
#         cur_result2 += [w1]
#         cur_result2 += [p2]
#         table[team2] = cur_result2
#
# for q, w in table.items():
#     print((q+':'), *w, end='\n')

# alfabet = input()
# codes = input()
# to_encrypt = input()
# to_decrypt = input()
#
# encrypt_table = {}
# for i in range(len(alfabet)):
#     encrypt_table[alfabet[i]] = codes[i]
#
# decrypt_table = {}
# for i in range(len(alfabet)):
#     decrypt_table[codes[i]] = alfabet[i]
#
# encrypted = ''
# for i in range(len(to_encrypt)):
#     encrypted += encrypt_table[to_encrypt[i]]
#
# decrypted = ''
# for i in range(len(to_decrypt)):
#     decrypted += decrypt_table[to_decrypt[i]]
#
# print(encrypted)
# print(decrypted)


# d = int(input())
# dict = set()
# for i in range(d):
#     w = input().lower()
#     dict.add(w)
#
# l = int(input())
# lines = []
# for line in range(l):
#     lines += [input()]
#
# errors = set()
# for line in lines:
#     words = line.split()
#     for w in words:
#         err = w.lower()
#         if err not in dict:
#             errors.add(err)
#
# for err in errors:
#     print(err, end='\n')

# формируем множество известных слов на основании построчного ввода
# dic = {input().lower() for _ in range(int(input()))}

# заводим пустое множество для приема текста
# wrd = set()

# т.к. текст построчно подается, а также в каждой строке несколько слов,
# то каждую строку превращаем во множество и добавляем в единое множество wrd
# for _ in range(int(input())):
#     wrd |= {i.lower() for i in input().split()}

# на вывод отправляем результат вычитания словарного множества dic
# из текстового множества wrd; впереди ставим *, чтобы раскрыть поэлементно
# print(*(wrd-dic), sep="\n")


# n = int(input())
#
# x = 0
# y = 0
# for k in range(n):
#     command = input().split(' ')
#     if command[0] == 'север':
#         y += int(command[1])
#     elif command[0] == 'юг':
#         y -= int(command[1])
#     elif command[0] == 'восток':
#         x += int(command[1])
#     else:
#         x -= int(command[1])
# print(str(x) + ' ' + str(y))
#
# n=int(input())
# d={'север':0,'запад':0,'юг':0,'восток':0}
# for i in range(n):
#     x=input().split()
#     d[x[0]]+=int(x[1])
# print(d['восток']-d['запад'], d['север']-d['юг'])
#

dic = {}

for cl in range(1, 12):
    dic[cl] = [0, 0]

file_name = 'file.txt'
with open(file_name, 'r') as inf:
    for line in inf:
        data = line.split('\t')
        value = dic[int(data[0])]
        value[0] += 1
        value[1] += int(data[2])
        dic[int(data[0])] = value

for i in range(1, 12):
    value = dic[i]
    if value[0] != 0:
        print(str(i) + ' ' + str((value[1] / value[0])))
    else:
        print(str(i) + ' - ')