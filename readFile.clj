;Author: Cong Nguyen
;File: Assignment9.clj

(defn getFrequency [fileName]
		(spit "Output9.txt" (sort-by last >(frequencies (for [word (re-seq #"[a-zA-Z]+" (slurp fileName))]
			(.toLowerCase word))))))


		

