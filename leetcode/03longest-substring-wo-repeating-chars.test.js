var lengthOfLongestSubstring = function (s) {
    const n = s.length;
    var maxLen = 0;
    var currLen = 0;
    var currCharMap = {};
    for (var i = 0; i < n; i++) {
        const currChar = s[i];
        if (currCharMap[currChar] === undefined || currChar[currChar] === null) {
            currLen += 1;

        } else {
            currLen = Math.min(i - currCharMap[currChar], currLen + 1);
        }
        currCharMap[currChar] = i;
        maxLen = Math.max(currLen, maxLen);

    }
    return maxLen;
};

describe('lengthOfLongestSubstring', () => {
    it('test case 1', () => {
        expect(lengthOfLongestSubstring(' ')).toBe(1);
    })
    it('test case 2', () => {
        expect(lengthOfLongestSubstring('abcabd')).toBe(4);
    });
    it('test case 3', () => {
        expect(lengthOfLongestSubstring('bbbbbb')).toBe(1);
    });
    it('test case 4', () => {
        expect(lengthOfLongestSubstring('b')).toBe(1);
    });
    it('test case 5', () => {
        expect(lengthOfLongestSubstring('abcdef')).toBe(6);
    });
    it('test case 6', () => {
        expect(lengthOfLongestSubstring('dvdf')).toBe(3);
    });
    it('test case 7', () => {
        expect(lengthOfLongestSubstring('abcabcd')).toBe(4);
    });
    it('test case 8', () => {
        expect(lengthOfLongestSubstring('pwwkew')).toBe(3);
    });
    it('test case 9', () => {
        expect(lengthOfLongestSubstring('abcabcbb')).toBe(3);
    });
    it('test case 10', () => {
        expect(lengthOfLongestSubstring('abcac')).toBe(3);
    });
    it('test case 11', () => {
        expect(lengthOfLongestSubstring('abba')).toBe(2);
    })
})