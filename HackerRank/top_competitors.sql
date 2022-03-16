SELECT HACKERS.hacker_id, HACKERS.name FROM HACKERS
JOIN (
    SELECT Submissions.hacker_id, count(*) AS problem FROM Submissions
        JOIN (
            SELECT Challenges.challenge_id, DIFFICULTY.score FROM Challenges
            JOIN DIFFICULTY ON DIFFICULTY.difficulty_level = Challenges.difficulty_level
    ) AS SCORE
    ON SCORE.challenge_id = Submissions.challenge_id
    WHERE SCORE.score = Submissions.score
    GROUP BY hacker_id
    HAVING problem > 1
) AS RESULT
ON RESULT.hacker_id = HACKERS.hacker_id
ORDER BY RESULT.problem DESC, HACKERS.hacker_id;

