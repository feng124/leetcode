package oj.leetcode.string.version;

/**
 * 
 * Compare two version numbers version1 and version2. If version1 > version2
 * return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character. The . character does not represent a decimal point and
 * is used to separate number sequences. For instance, 2.5 is not
 * "two and a half" or "half way to version three", it is the fifth second-level
 * revision of the second first-level revision.
 * 
 * Here is an example of version numbers ordering:
 * 
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 */
public class VersionCompare {

	public int compareVersion(String version1, String version2) {

//		if (version1 == null && version2 == null) {
//			return 0;
//		} else if (version1 == null && version2 != null) {
//			return -1;
//		} else if (version1 != null && version2 == null) {
//			return 1;
//		}

		int main_ver1 = 0;
		String res_ver1 = null;
		if (version1 != null) {
			int pp = version1.indexOf('.');

			if (pp == -1) {
				main_ver1 = Integer.parseInt(version1);
			} else {
				main_ver1 = Integer.parseInt(version1.substring(0, pp));
				res_ver1 = version1.substring(pp + 1);
			}
		}

		int main_ver2 = 0;
		String res_ver2 = null;
		if (version2 != null) {
			int pp = version2.indexOf('.');

			if (pp == -1) {
				main_ver2 = Integer.parseInt(version2);
			} else {
				main_ver2 = Integer.parseInt(version2.substring(0, pp));
				res_ver2 = version2.substring(pp + 1);
			}
		}

		if (main_ver1 < main_ver2) {
			return -1;
		} else if (main_ver1 > main_ver2) {
			return 1;
		}
		
		if (res_ver1 == null && res_ver2 == null) {
			return 0;
		}

		return compareVersion(res_ver1, res_ver2);
	}

}
