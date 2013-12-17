;Author: Cong Nguyen
;File: Assignment10.clj

(def balanceA (ref 1000))
(def balanceB (ref 2000))
(def agentCount (agent 1))

;;transfer function
(defn transfer [balanceA balanceB amount futureNum waitingTime]
		(dosync 	
			(println "Trying:" futureNum waitingTime)
			(alter balanceA - amount) 
			(Thread/sleep waitingTime)
			(alter balanceB + amount)
			(do
			(println "Transfered:" futureNum @agentCount)
			(send-off agentCount inc))))

;;futureA 
(def futureA (future (dotimes[n 10](transfer balanceA balanceB 20 1 (rand-int 100)))))

(def futureB (future (dotimes[n 10](transfer balanceA balanceB 15 2 (rand-int 40)))))


		
;;dereference
@futureA
@futureB

;;print out the result
(println "Result:" @balanceA @balanceB)
