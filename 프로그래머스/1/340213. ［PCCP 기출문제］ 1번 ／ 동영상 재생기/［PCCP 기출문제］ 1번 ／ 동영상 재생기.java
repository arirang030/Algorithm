// 10초 전 이동 시: 현재 위치가 10초 미만일 시 처음 위치로 이동
// 10초 후 이동 시: 남은 시간이 10초 미만일 시 마지막 위치로 이동
// 오프닝 건너뛰기: 현재 위치가 오프닝 시간 사이일 경우 오프닝 마지막 시간으로 이동
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int mm = Integer.parseInt(pos.substring(0, 2));
        int ss = Integer.parseInt(pos.substring(3, 5));
        
        int time = mm * 60 + ss;
        
        int op_start_mm = Integer.parseInt(op_start.substring(0, 2));
        int op_start_ss = Integer.parseInt(op_start.substring(3, 5));
        
        int op_start_time = op_start_mm * 60 + op_start_ss;
        
        int op_end_mm = Integer.parseInt(op_end.substring(0, 2));
        int op_end_ss = Integer.parseInt(op_end.substring(3, 5));
        
        int op_end_time = op_end_mm * 60 + op_end_ss;
        
        int video_end_mm = Integer.parseInt(video_len.substring(0, 2));
        int video_end_ss = Integer.parseInt(video_len.substring(3, 5));
        
        int video_end_time = video_end_mm * 60 + video_end_ss;
        // 오프닝 건너뛰기
            if (time >= op_start_time && time <= op_end_time) {
                time = op_end_time;
            }
        for (String command : commands) {
            
            // 10초 전으로 이동
            if (command.equals("prev")) {
                if (time - 10 < 0) {
                    time = 0;
                } else {
                    time -= 10;
                }
            }
            // 10초 후로 이동
            if (command.equals("next")) {
                // 남은 시간이 10초 미만인 경우
                if (video_end_time - time < 10) {
                    time = video_end_time;
                } else {
                    time += 10;
                }
            }
            
            // 오프닝 건너뛰기
            if (time >= op_start_time && time <= op_end_time) {
                time = op_end_time;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", time / 60));
        sb.append(":");
        sb.append(String.format("%02d", time % 60));
        
        return sb.toString();
    }
}