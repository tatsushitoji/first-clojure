;;;メイン。MVCの"C"に相当。
;;;ユーザのコマンドをViewから受け取り、それを処理する。
(ns othe.core
  (:use
    othe.view
    othe.model))

(defn on-command
  "Viewからのコマンド通知を処理するハンドラ。
引数はベクタで、最初の要素は、:moveか:exit。
:moveの場合、第2要素にposを指定する。"
  [cmdline]
  (let [cmd (first cmdline)
        pos (second cmdline)]
    (cond
      (= cmd :move) (play-move pos)
      (= cmd :exit) (System/exit 0)
      :else nil)))

; (defn- say
;   [n]
;   (* n 2))

(defn -main
  "エントリポイント。"
  [& args]
  (init-view on-command)
  (init-game on-state-changed)
  (start-ui))
