# Shadowing bindings does not work as expected

This repo reproduces a bug with core.match, or (far less likely) with the macro expansion in Clojure.

This code:

```
(let [foo [:bar :baz]]
  (match foo
    [:bar boo] boo
    :else :got-else))
```

returns `:baz`. While this code:

```
(let [foo [:bar :baz]]
  (match foo
    [:bar foo] foo
    :else :got-else))
```

returns `:got-else`.

They should be equal, since the `foo` in the match should shadow the `foo` in
the let. In fact, when running `macroexpand-1` on these forms, they only differ in
the gensym numbers and the letter `f` vs `b` in `foo` and `bar`.

Run the example with:

```
clj -m repro
```
