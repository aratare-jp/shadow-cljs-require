# How to reproduce
```
git clone git@github.com:aratare-jp/shadow-cljs-require.git

yarn install

yarn shadow-cljs server
```

Then move on to the dashboard, compile and open the app normally.

You should see this error popping up in the console:
```
Uncaught (in promise) Module not provided: ./assets/plus.js
```

# Solution
As per answerd [here](https://github.com/thheller/shadow-cljs/issues/840#issuecomment-776665299), add the following options to your build:

```clojure
:js-options
{:js-provider    :external
 :external-index "target/index.js"}
```

This project's `shadow-cljs.edn` has been updated to include the above block.

Then run the following command (assuming you already have webpack installed):

```bash
npx webpack --entry target/index.js --output public/js/libs.js
```

Then inside your index.html, include the newly generated `libs.js`:

```javascript
<script defer src="/js/libs.js"></script>
<script defer src="/js/main.js"></script>
```

