from abc import ABC, abstractmethod
import platform

# interface
class Component(ABC): #abstract class
    @abstractmethod #not gonna implement
    def render(self)->str:
        pass

class WindowsPlayButton(Component): # extending Component class so need to implement here
    def render(self) -> str:
        return "render Windows play button"

class WindowsTimeline(Component): # extending Component class so need to implement here
    def render(self) -> str:
        return "render Windows Timeline"

class WindowsWindow(Component): # extending Component class so need to implement here
    def render(self) -> str:
        return "render Windows window"


class MacPlayButton(Component):
    def render(self)->str:
        return "render Mac play button"

class MacTimeline(Component): # extending Component class so need to implement here
    def render(self) -> str:
        return "render Mac Timeline"

class MacWindow(Component): # extending Component class so need to implement here
    def render(self) -> str:
        return "render Mac window"

class AbstractPlayerComponentFactory(ABC):
    @abstractmethod
    def create_component(self, component_type: str) -> Component:
        pass


class WindowsPlayerComponentFactory(AbstractPlayerComponentFactory):
    def create_component(self, component_type: str) -> Component:
        if component_type == "play_button":
            return WindowsPlayButton()
        if component_type == "timeline":
            return WindowsTimeline()
        if component_type == "window":
            return WindowsWindow()

class MacPlayerComponentFactory(AbstractPlayerComponentFactory):
    def create_component(self, component_type: str) -> Component:
        if component_type == "play_button":
            return MacPlayButton()
        if component_type == "timeline":
            return MacTimeline()
        if component_type == "window":
            return MacWindow()


def client(factory: AbstractPlayerComponentFactory) -> None:
    window = factory.create_component("window")
    timeline = factory.create_component("timeline")
    play_button = factory.create_component("play_button")

    print(f"{window.render()}, => {timeline.render()}, => {play_button.render()}")

if __name__ == "__main__":
    current_os = platform.system()
    if current_os == "Windows":
        client(WindowsPlayerComponentFactory())
    if current_os in ["Mac", "Darwin"]:
        client(MacPlayerComponentFactory())
                                             



