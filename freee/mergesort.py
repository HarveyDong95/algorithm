def merge_sort(a):
    if len(a) <= 1:
        return a
    
    mid = len(a) // 2
    # print(mid)
    left = merge_sort(a[:mid])
    right = merge_sort(a[mid:])
    return merge(left,right)

#coding: utf-8
def merge(left,right):
    # n = len(left) + len(right)

    i = 0
    j = 0
    A = []
    # for k in range(0,n):
    #     if left[i] <= right[j]:
    #         A.append(left[i])
    #         i = i+1
    #     else:
    #         A.append(right[j])
    #         j = j+1
    while i < len(left) and j < len(right):
        # print(left[i],"and i", i)
        # print(right[j],"and j", j, right)
        if left[i] <= right[j]:
            A.append(left[i])
            i = i + 1
        else:
            A.append(right[j])
            j = j + 1

    A.extend(left[i:])
    A.extend(right[j:])

    return A 


if __name__ == '__main__':
    Arr = [2,4,1,65,22,6,7,34,5,8]
    sorted_arr = merge_sort(Arr)
    print(sorted_arr)