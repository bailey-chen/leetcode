class Solution(object):
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        if len(p) == 0:
            return len(s) == 0;
        if len(s) == 0: return True;

        # pretend no '*'
        first_match = p[0] in [s[0], "."]

        # if '*' exists:
        if len(p) > 1 and p[1] == "*":
            # matches: s[1:], p
            if s[0] == p[0]:
                return self.isMatch(s[1:], p)

            # not match: s, p[2:]
            else:
                return self.isMatch(s, p[2:])
        else:
            return first_match and self.isMatch(s[1:], p[1:])

