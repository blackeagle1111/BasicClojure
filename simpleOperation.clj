;Author: Cong Nguyen
;File: Assignment8.clj


(defn adj [value1 value2]
	(let [result (+ (/ value1 2) (/ value2 2))]
	(if (= (mod result 2) 1)
		(+ result 1)
		result
	))
)

(defn pass [list]
	(let [[a b c d] list] 
		[(adj c a) (adj a b) (adj b c) (+ d 1)]))

(defn func3 [list]
	(loop [v  (vec list) r []]
	(if(= (v 0) (v 1) (v 2))
		;print out the result		
		(println (seq r))
		(let[result (pass v)
			r (conj r result)]
		(recur result r))
		)))
		

