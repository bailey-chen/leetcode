class Solution(object):

    def reverse(self, x):
        neg_bound = (-1) * 2**31
        pos_bound = 2**31 - 1

        neg = False;
        x_str = str(x)
        if x_str[0] == '-':
            neg = True;
            x_str = x_str[1:]

        lst = []
        for c in x_str:
            lst.insert(0, c)
        if neg:
            lst.insert(0, '-')
        num = int(''.join(lst))
        if num < neg_bound or num > pos_bound:
            return 0
        else:
            return num