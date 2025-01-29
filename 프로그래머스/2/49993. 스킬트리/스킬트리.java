import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        Set<Character> skillset = new LinkedHashSet<>();
        int count = 0;

        for (int i = 0; i < skill.length(); i++) {
            skillset.add(skill.charAt(i));
        }

        for (String s : skill_trees) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (skillset.contains(s.charAt(i))) {
                    sb.append(s.charAt(i));
                }
            }

            // 스킬 순서를 만족하는지 확인
            if (isValidSkillTree(skill, sb.toString())) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidSkillTree(String skill, String learned) {
        return skill.startsWith(learned);
    }
}
