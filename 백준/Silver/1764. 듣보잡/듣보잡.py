no_hear_cnt,no_see_cnt=map(int,input().split())
not_heard=dict()
no_hear_no_see=list()
for i in range(no_hear_cnt):
    not_heard[input()]=1
for j in range(no_see_cnt):
    name = input()
    if name in not_heard.keys():
        no_hear_no_see.append(name)
no_hear_no_see.sort()
print(len(no_hear_no_see))
for no_hc_name in no_hear_no_see:
    print(no_hc_name)