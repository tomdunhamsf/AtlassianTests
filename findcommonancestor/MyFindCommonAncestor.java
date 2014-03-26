package findcommonancestor;

import java.util.*;
public class MyFindCommonAncestor implements FindCommonAncestor {

	@Override
	public String findCommmonAncestor(String[] commitHashes,
			String[][] parentHashes, String commitHash1, String commitHash2) {
		Map<String, String[]> branches =new HashMap<String, String[]>();
		for (int i = 0; i < commitHashes.length; i++) {
			branches.put(commitHashes[i], parentHashes[i]);
		}
		Set<String> branch = new HashSet<String>();
		String commit1 = commitHash1;
		while (commit1 != null) {
			String[] parents = branches.get(commit1);
			if (parents == null) {
				commit1 = null;
			} else if (parents.length> 0) {
				for (String parent : parents) {
					branch.add(parent);
					commit1 = parent;
				}
			}
		}
		String commit2 = commitHash2;
		while (commit2 != null) {
			if (branch.contains(commit2)) {
				return commit2;
			}
			String[] parents = branches.get(commit2);
			for (String parent : parents) {
				if (branch.contains(parent)) {
					return parent;
				}
				commit2 = parent;
			}
		}
		return null;
	}

}
