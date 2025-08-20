(function () {
  console.log("[ReadmeBlocker] Loaded");

  window.addEventListener("DOMContentLoaded", () => {
    const patch = () => {
      const originalOpenEditor =
        window.monaco && window.monaco.editor
          ? window.monaco.editor.openEditor
          : null;

      if (!originalOpenEditor) {
        console.warn("[ReadmeBlocker] monaco.editor not ready, retrying...");
        setTimeout(patch, 1000);
        return;
      }

      window.monaco.editor.openEditor = function (input, options, group) {
        try {
          const resource = input.resource || input.editor?.resource;
          if (resource) {
            const fileName = resource.path
              ? resource.path.split("/").pop().toLowerCase()
              : "";

            if (fileName === "readme.md" && input.viewType?.includes("markdown")) {
              console.log("[ReadmeBlocker] Blocking preview for README.md");
              return group.openEditor(
                { resource, viewType: "default" },
                options
              );
            }
          }
        } catch (err) {
          console.error("[ReadmeBlocker] Error:", err);
        }

        return originalOpenEditor.call(this, input, options, group);
      };
    };

    patch();
  });
})();
