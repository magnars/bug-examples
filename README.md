# Code splitting with lein-figwheel

This is a small project reproducing the issue in [lein-figwheel#613](https://github.com/bhauman/lein-figwheel/issues/613).

## Check it out

- well, yeah, start by checking it out. :-)

  ```
  git clone git@github.com:magnars/bug-examples.git
  cd bug-examples
  git checkout lein-figwheel-613
  ```

- `lein figwheel`
- Open the webpage. There's a button. Press it to load the `baz.core` module.
- Make changes to `baz.core`. Note that they are not loaded by figwheel.

Thanks for taking the time to take a look, Bruce!

Kind regards, Magnar
